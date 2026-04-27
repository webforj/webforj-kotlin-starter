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
class DashboardViewIT {

  companion object {
    val playwright: Playwright = Playwright.create()
  }

  var browser: Browser? = null
  var page: Page? = null

  @LocalServerPort
  private var port: Int = 0

  @BeforeEach
  fun setUp() {
    browser = playwright.chromium().launch()
    page = browser!!.newPage()
    page!!.navigate("http://localhost:$port/")
  }

  @AfterEach
  fun tearDown() {
    browser?.close()
  }

  @Test
  fun shouldRenderPage() {
    assertThat(page!!.locator(".explore-component"))
      .containsText("Your dashboard is empty")
  }
}
