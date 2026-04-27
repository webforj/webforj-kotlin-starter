package com.webforjkotlinstarter.components

import com.webforj.App
import com.webforj.component.Composite
import com.webforj.component.html.elements.Div
import com.webforj.component.icons.IconButton
import com.webforj.component.icons.TablerIcon

class ThemeToggle : Composite<Div>() {
  private val self = boundComponent
  private val button = IconButton(TablerIcon.create(iconForTheme(App.getTheme())))

  init {
    button.onClick {
      val next = if ("dark" == App.getTheme()) "light" else "dark"
      App.setTheme(next)
      button.name = iconForTheme(next)
    }
    self.add(button)
  }
}

private fun iconForTheme(theme: String): String =
  if ("dark" == theme) "sun" else "moon"
