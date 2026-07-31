# AGENTS.md

This is a webforJ project written in Kotlin: the UI is built by composing webforJ components through the webforJ Kotlin DSL.

## Commands

- `mvn` — dev mode. The default goal (`compile webforj:watch spring-boot:run`) compiles the frontend, watches `src/main/frontend`, and serves the app.
- `mvn verify` — run the `*IT` integration tests (Playwright).
- `mvn -Pprod package` — production build into `target/`.

Java version, Kotlin version, dependencies, plugins, and the run goal are declared in `pom.xml` — read them there instead of assuming.

## Layout

- `src/main/kotlin/.../Application.kt` — entry point, an `object` extending `App`. `@Routify` scans the `views` package and `@BundleEntry("app.css")` loads the app stylesheet.
- `src/main/kotlin/.../views/` — routes. Each is a `@Route`-annotated `Composite`.
- `src/main/kotlin/.../components/` — reusable `Composite` components.
- `src/main/frontend/` — frontend sources compiled by the webforJ Maven plugin. `app.css` lives here.
- `src/main/resources/` — `application.properties` for runtime config.

## webforJ MCP server

Already configured in this repo at `https://mcp.webforj.com/mcp`.

- Resolve the webforJ version from `pom.xml`, and scope every answer to it.
- Look up webforJ classes, methods, and annotations through the server — don't guess them.
- Kotlin DSL builders live under `type: "kotlin"` in the knowledge base — search that type, not `"sample"`, when writing Kotlin.
- Validate every `--dwc-*` CSS token through the server before using it.

## Kotlin DSL

- Prefer the DSL builders (`h1 { }`, `flexLayout { }`, `appNav { }`, slot builders like `headerSlot { }`) over calling the Java setters directly.
- Prefer property syntax (`spacing = "0"`, `styles["margin"] = "0"`) over `setX(...)` calls.
- Extension helpers such as `100.percent` and `prefixSlot { }` come from `com.webforj.kotlin.extension` — import them rather than reimplementing.

## Testing

Integration tests use Playwright and live in `src/test/kotlin/.../views/` as `<View>IT.kt`. `mvn verify` runs them. A test launches Chromium, navigates to `http://localhost:<port>/`, and asserts with `PlaywrightAssertions.assertThat(...)`. Name the class `*IT` so the failsafe plugin runs it, and add one per view.

## Do's and Don'ts

- **Do** style with DWC tokens (`--dwc-*`) and set the app color via `--dwc-color-primary-seed` in `src/main/frontend/app.css`.
- **Do** follow the DWC design system — https://dwc.style/docs/design.md is the full token catalog (colors, typography, spacing, shadows, motion) and component recipes. Every value is a `var(--dwc-*)` token you consume directly.
- **Do** add a `<View>IT` test for each new view, and run `mvn verify` before finishing.
- **Don't** hardcode colors, sizes, or raw CSS values — use `--dwc-*` tokens.
- **Don't** guess webforJ APIs or token names — resolve them through the MCP server.
- **Don't** edit anything under `target/` or other generated output.
- **Don't** add dependencies or change the build without checking `pom.xml` first.
