package com.webforjkotlinstarter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import com.webforj.App
import com.webforj.annotation.AppProfile
import com.webforj.annotation.AppTheme
import com.webforj.annotation.Routify
import com.webforj.bundle.annotation.BundleEntry

@SpringBootApplication
@Routify(packages = ["com.webforjkotlinstarter.views"])
@BundleEntry("app.css")
@AppTheme("system")
@AppProfile(name = "webforj-kotlin-starter", shortName = "webforj-kotlin-starter")
object Application : App()

fun main(args: Array<String>) {
  SpringApplication.run(Application::class.java, *args)
}
