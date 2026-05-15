# ADR-001 — Arquitetura Hexagonal (Ports & Adapters)

## Status
Aceito

## Contexto
O problema exige uma solução de busca de subarray que seja testável, extensível e com responsabilidades bem definidas. Mesmo sendo um teste técnico de escopo reduzido, a escolha arquitetural demonstra intenção de design.

## Decisão
Adotar a **Arquitetura Hexagonal** com as seguintes camadas:

| Camada | Responsabilidade |
|---|---|
| `domain` | Modelos, portas (interfaces), validação e factory — sem dependência de nenhuma outra camada |
| `application` | Casos de uso e estratégias de algoritmo — depende apenas do domínio |
| `infrastructure` | Implementações de repositório — depende do domínio |
| `adapter` | Entrada/saída (CLI) e wiring — depende de todas as camadas |

## Consequências
- **Positivo:** domínio completamente isolado e testável sem infraestrutura
- **Positivo:** adicionar novos adapters (REST, gRPC) ou repositórios (banco, arquivo) não altera domínio nem application
- **Negativo:** mais arquivos/pacotes do que o estritamente necessário para o problema dado
