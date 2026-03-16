package com.webforjkotlinstarter.views

import com.microsoft.playwright.Browser
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InboxViewIT {

  companion object {
    val playwright: Playwright = Playwright.create()
  }

  var browser: Browser? = null
  var page: Page? = null

  @LocalServerPort
  private var port: Int = 0

  @BeforeEach
  fun setUp() {
    // By default, Playwright runs the browsers in headless mode. To see the browser
    // UI, setHeadless option to false. You can also use setSlowMo to slow down
    // execution. Learn more in the debugging tools section.
    // https://playwright.dev/java/docs/debug

    // browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50.0))

    browser = playwright.chromium().launch()
    page = browser!!.newPage()
    page!!.navigate("http://localhost:$port/")
  }

  @AfterEach
  fun tearDown() {
    browser?.close()
  }

  @Test
  fun shouldClickButton() {
    assertThat(page!!.locator(".explore-component"))
      .containsText("Inbox")
  }
}
