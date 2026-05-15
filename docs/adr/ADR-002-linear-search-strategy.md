# ADR-002 — Algoritmo de Busca: Linear Search vs KMP

## Status
Aceito

## Contexto
O problema requer encontrar a posição inicial de um subarray (target) dentro de um array maior (universo). Existem algoritmos com diferentes complexidades para esse problema:

| Algoritmo | Tempo | Espaço | Complexidade de implementação |
|---|---|---|---|
| **Linear Search (atual)** | O(n × m) | O(1) | Baixa |
| Knuth-Morris-Pratt (KMP) | O(n + m) | O(m) | Alta |
| Boyer-Moore | O(n / m) melhor caso | O(m) | Muito alta |
| Rabin-Karp | O(n + m) médio | O(1) | Média |

Onde `n` = tamanho do universo e `m` = tamanho do target.

## Decisão
Usar **Linear Search** via `LinearSearchStrategy`.

**Justificativas:**
1. Para os tamanhos de array do domínio do problema (pequenos), O(n × m) é indistinguível de O(n + m) na prática
2. Legibilidade e manutenibilidade são maiores
3. A interface `SubarraySearchStrategy` permite substituir por KMP sem alterar nenhuma outra classe (Open/Closed Principle)

## Como evoluir
Para adotar KMP basta criar `KmpSearchStrategy implements SubarraySearchStrategy` e trocar o wiring em `AppFactory.createUseCase()`. Nenhuma outra classe precisa ser modificada.

## Consequências
- **Positivo:** código simples, sem bugs sutis de implementação
- **Negativo:** degradação de performance para universos com milhões de elementos e targets com muita repetição parcial
