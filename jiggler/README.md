# Compila o arquivo Kotlin em um JAR

kotlinc jiggler.kt -include-runtime -d jiggler.jar

# Executa o JAR compilado

java -jar jiggler.jar
