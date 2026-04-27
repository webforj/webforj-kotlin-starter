package com.webforjkotlinstarter.components

import com.webforj.component.Composite
import com.webforj.component.Theme
import com.webforj.component.button.ButtonTheme
import com.webforj.component.icons.TablerIcon
import com.webforj.component.layout.flexlayout.FlexAlignment
import com.webforj.component.layout.flexlayout.FlexDirection
import com.webforj.component.layout.flexlayout.FlexJustifyContent
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.component.toast.Toast
import com.webforj.kotlin.dsl.component.button.button
import com.webforj.kotlin.dsl.component.html.elements.paragraph
import com.webforj.kotlin.dsl.component.icons.tablerIcon
import com.webforj.kotlin.dsl.component.layout.flexlayout.flexLayout
import com.webforj.kotlin.extension.classNames
import com.webforj.kotlin.extension.em
import com.webforj.kotlin.extension.percent
import com.webforj.kotlin.extension.plusAssign
import com.webforj.kotlin.extension.prefixSlot
import com.webforj.kotlin.extension.px
import com.webforj.kotlin.extension.set
import com.webforj.kotlin.extension.styles

class Explore(message: String, iconName: String, ctaLabel: String) : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.apply {
      classNames += "explore-component"
      direction = FlexDirection.COLUMN
      alignment = FlexAlignment.CENTER
      justifyContent = FlexJustifyContent.CENTER
      maxWidth = 300.px
      spacing = 0.75.em
      height = 100.percent
      styles["margin"] = "${1.em} auto"

      flexLayout {
        alignment = FlexAlignment.CENTER
        justifyContent = FlexJustifyContent.CENTER
        styles["width"] = "6rem"
        styles["height"] = "6rem"
        styles["border-radius"] = "50%"
        styles["background"] = "var(--dwc-color-primary-alt)"
        styles["color"] = "var(--dwc-color-on-primary-text-alt)"

        tablerIcon(iconName) {
          styles["font-size"] = "3rem"
        }
      }

      paragraph(message) {
        styles["color"] = "var(--dwc-color-gray-text-light)"
        styles["margin"] = "0"
      }

      button(ctaLabel, ButtonTheme.PRIMARY) {
        prefixSlot { TablerIcon.create("plus") }
        onClick {
          Toast.show("\"$ctaLabel\" is not wired up yet", 3000, Theme.INFO, Toast.Placement.BOTTOM_RIGHT)
        }
      }
    }
  }
}
