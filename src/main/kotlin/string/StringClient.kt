package string

fun main() {
    val script = """
        <script>
            alert('This is a multiline String')
        </script>
    """.trimIndent()

    println(script)
}