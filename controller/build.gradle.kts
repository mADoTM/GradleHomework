plugins {
    application
}

dependencies {
    implementation(project(":models"))
    implementation("com.google.code.gson:gson:2.9.1")
}

application {
    mainClass.set("ru.mail.Application")
}