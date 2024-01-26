import java.util.Random
import java.util.Scanner

val romajiToHiragana = mapOf(
    "a" to listOf("あ"),
    "i" to listOf("い"),
    "u" to listOf("う"),
    "e" to listOf("え"),
    "o" to listOf("お"),
    "ka" to listOf("か"),
    "ki" to listOf("き"),
    "ku" to listOf("く"),
    "ke" to listOf("け"),
    "ko" to listOf("こ"),
    "sa" to listOf("さ"),
    "shi" to listOf("し"),
    "su" to listOf("す"),
    "se" to listOf("せ"),
    "so" to listOf("そ"),
    "ta" to listOf("た"),
    "chi" to listOf("ち"),
    "tsu" to listOf("つ"),
    "te" to listOf("て"),
    "to" to listOf("と"),
    "na" to listOf("な"),
    "ni" to listOf("に"),
    "nu" to listOf("ぬ"),
    "ne" to listOf("ね"),
    "no" to listOf("の"),
    "ha" to listOf("は"),
    "hi" to listOf("ひ"),
    "fu" to listOf("ふ"),
    "he" to listOf("へ"),
    "ho" to listOf("ほ"),
    "ma" to listOf("ま"),
    "mi" to listOf("み"),
    "mu" to listOf("む"),
    "me" to listOf("め"),
    "mo" to listOf("も"),
    "ya" to listOf("や"),
    "yu" to listOf("ゆ"),
    "yo" to listOf("よ"),
    "ra" to listOf("ら"),
    "ri" to listOf("り"),
    "ru" to listOf("る"),
    "re" to listOf("れ"),
    "ro" to listOf("ろ"),
    "wa" to listOf("わ"),
    "wo" to listOf("を"),
    "n" to listOf("ん"),
    "ga" to listOf("が"),
    "gi" to listOf("ぎ"),
    "gu" to listOf("ぐ"),
    "ge" to listOf("げ"),
    "go" to listOf("ご"),
    "za" to listOf("ざ"),
    "ji" to listOf("じ", "ぢ"),
    "zu" to listOf("ず", "づ"),
    "ze" to listOf("ぜ"),
    "zo" to listOf("ぞ"),
    "da" to listOf("だ"),
    "de" to listOf("で"),
    "do" to listOf("ど"),
    "ba" to listOf("ば"),
    "bi" to listOf("び"),
    "bu" to listOf("ぶ"),
    "be" to listOf("べ"),
    "bo" to listOf("ぼ"),
    "pa" to listOf("ぱ"),
    "pi" to listOf("ぴ"),
    "pu" to listOf("ぷ"),
    "pe" to listOf("ぺ"),
    "po" to listOf("ぽ"),
    "kya" to listOf("きゃ"),
    "kyu" to listOf("きゅ"),
    "kyo" to listOf("きょ"),
    "sha" to listOf("しゃ"),
    "shu" to listOf("しゅ"),
    "sho" to listOf("しょ"),
    "cha" to listOf("ちゃ"),
    "chu" to listOf("ちゅ"),
    "cho" to listOf("ちょ"),
    "nya" to listOf("にゃ"),
    "nyu" to listOf("にゅ"),
    "nyo" to listOf("にょ"),
    "hya" to listOf("ひゃ"),
    "hyu" to listOf("ひゅ"),
    "hyo" to listOf("ひょ"),
    "mya" to listOf("みゃ"),
    "myu" to listOf("みゅ"),
    "myo" to listOf("みょ"),
    "rya" to listOf("りゃ"),
    "ryu" to listOf("りゅ"),
    "ryo" to listOf("りょ")
)

val romajiToKatakana = mapOf(
    "a" to listOf("ア"),
    "i" to listOf("イ"),
    "u" to listOf("ウ"),
    "e" to listOf("エ"),
    "o" to listOf("オ"),
    "ka" to listOf("カ"),
    "ki" to listOf("キ"),
    "ku" to listOf("ク"),
    "ke" to listOf("ケ"),
    "ko" to listOf("コ"),
    "sa" to listOf("サ"),
    "shi" to listOf("シ"),
    "su" to listOf("ス"),
    "se" to listOf("セ"),
    "so" to listOf("ソ"),
    "ta" to listOf("タ"),
    "chi" to listOf("チ"),
    "tsu" to listOf("ツ"),
    "te" to listOf("テ"),
    "to" to listOf("ト"),
    "na" to listOf("ナ"),
    "ni" to listOf("ニ"),
    "nu" to listOf("ヌ"),
    "ne" to listOf("ネ"),
    "no" to listOf("ノ"),
    "ha" to listOf("ハ"),
    "hi" to listOf("ヒ"),
    "fu" to listOf("フ"),
    "he" to listOf("ヘ"),
    "ho" to listOf("ホ"),
    "ma" to listOf("マ"),
    "mi" to listOf("ミ"),
    "mu" to listOf("ム"),
    "me" to listOf("メ"),
    "mo" to listOf("モ"),
    "ya" to listOf("ヤ"),
    "yu" to listOf("ユ"),
    "yo" to listOf("ヨ"),
    "ra" to listOf("ラ"),
    "ri" to listOf("リ"),
    "ru" to listOf("ル"),
    "re" to listOf("レ"),
    "ro" to listOf("ロ"),
    "wa" to listOf("ワ"),
    "wo" to listOf("ヲ"),
    "n" to listOf("ン"),
    "ga" to listOf("ガ"),
    "gi" to listOf("ギ"),
    "gu" to listOf("グ"),
    "ge" to listOf("ゲ"),
    "go" to listOf("ゴ"),
    "za" to listOf("ザ"),
    "ji" to listOf("ジ", "ヂ"),
    "zu" to listOf("ズ", "ヅ"),
    "ze" to listOf("ゼ"),
    "zo" to listOf("ゾ"),
    "da" to listOf("ダ"),
    "de" to listOf("デ"),
    "do" to listOf("ド"),
    "ba" to listOf("バ"),
    "bi" to listOf("ビ"),
    "bu" to listOf("ブ"),
    "be" to listOf("ベ"),
    "bo" to listOf("ボ"),
    "pa" to listOf("パ"),
    "pi" to listOf("ピ"),
    "pu" to listOf("プ"),
    "pe" to listOf("ペ"),
    "po" to listOf("ポ"),
    "kya" to listOf("キャ"),
    "kyu" to listOf("キュ"),
    "kyo" to listOf("キョ"),
    "sha" to listOf("シャ"),
    "shu" to listOf("シュ"),
    "sho" to listOf("ショ"),
    "cha" to listOf("チャ"),
    "chu" to listOf("チュ"),
    "cho" to listOf("チョ"),
    "nya" to listOf("ニャ"),
    "nyu" to listOf("ニュ"),
    "nyo" to listOf("ニョ"),
    "hya" to listOf("ヒャ"),
    "hyu" to listOf("ヒュ"),
    "hyo" to listOf("ヒョ"),
    "mya" to listOf("ミャ"),
    "myu" to listOf("ミュ"),
    "myo" to listOf("ミョ"),
    "rya" to listOf("リャ"),
    "ryu" to listOf("リュ"),
    "ryo" to listOf("リョ")
)

fun String.toHiragana(): String {
    val random = Random()
    val hiraganaList = romajiToHiragana[this]
    return hiraganaList?.get(random.nextInt(hiraganaList.size)) ?: "Caractere desconhecido"
}

fun String.toKatakana(): String {
    val random = Random()
    val katakanaList = romajiToKatakana[this]
    return katakanaList?.get(random.nextInt(katakanaList.size)) ?: "Caractere desconhecido"
}

fun getUserChoice(): Int {
    println("Escolha o modo: \n1. Hiragana \n2. Katakana \n3. Hiragana/Katakana")
    val scanner = Scanner(System.`in`)
    val choiceInput = scanner.nextLine()
    return choiceInput.toIntOrNull() ?: 3
}

fun playARound(random: Random, choice: Int) {
    val isHiragana = when (choice) {
        1 -> true
        2 -> false
        else -> random.nextDouble() < 0.75
    }

    val selectedMap = if (isHiragana) romajiToHiragana else romajiToKatakana

    val randomKey = selectedMap.keys.random()
    val displayedCharacter = if (isHiragana) randomKey.toHiragana() else randomKey.toKatakana()

    println("Qual é o Romaji para ${if (isHiragana) "Hiragana" else "Katakana"}: $displayedCharacter?")
    val userResponse = readLine()

    if (userResponse != null && userResponse.lowercase() == randomKey) {
        println("Correto! ^_^")
    } else {
        println("Errado. T_T\nA resposta correta é: $randomKey")
    }
}

fun wantsToContinue(): Boolean {
    println("Deseja continuar? (s/n)")
    return readLine()?.lowercase() == "s"
}

fun main() {
    val random = Random()
    val choice = getUserChoice()

    do {
        playARound(random, choice)
    } while (wantsToContinue())
}

// kotlinc japones.kt -include-runtime -d japones.jar
// java -jar japones.jar

