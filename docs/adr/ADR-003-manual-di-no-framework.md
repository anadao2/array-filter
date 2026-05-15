# ADR-003 — Injeção de Dependência Manual (sem framework)

## Status
Aceito

## Contexto
O projeto precisa montar o grafo de objetos (wiring) em algum ponto. As opções são:

1. **Manual via `AppFactory`** (atual)
2. **Spring Framework / Spring Boot**
3. **Google Guice**
4. **CDI (Jakarta EE)**

## Decisão
Usar **injeção de dependência manual** centralizada em `AppFactory`.

**Justificativas:**
1. O escopo do problema não justifica o overhead de um container IoC
2. Evita dependências externas desnecessárias no `pom.xml`
3. O wiring manual é explícito, legível e rastreável sem magia de anotações
4. Todos os construtores já recebem dependências por parâmetro — migrar para Spring Boot no futuro exige apenas adicionar `@Component`/`@Service` sem reescrever lógica

## Consequências
- **Positivo:** zero dependências de framework no domínio e na application layer
- **Positivo:** startup instantâneo, sem classpath scanning
- **Negativo:** `AppFactory` precisa ser atualizada manualmente a cada nova dependência
