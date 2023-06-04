plugins {
    application
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

application {
    mainClass.set("com.fiap.burger.application.boot.BurgerApplication")
}

dependencies {
    implementation(project(":web"))
}