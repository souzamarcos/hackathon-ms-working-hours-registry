dependencies {
    implementation(project(":entity"))
    implementation(project(":usecase"))
    implementation(project(":controller"))

    implementation(rootProject.libs.spring.beans)
    implementation(rootProject.libs.openapi)
    implementation(rootProject.libs.spring.messaging)
    implementation(rootProject.libs.spring.cloud.starter.aws)
    implementation(rootProject.libs.spring.cloud.starter.aws.messaging)
    implementation(rootProject.libs.spring.boot.starter.data.jpa)
    implementation("com.google.guava:guava:23.6-jre")
    implementation("com.fatboyindustrial.gson-javatime-serialisers:gson-javatime-serialisers:1.1.2")
}
