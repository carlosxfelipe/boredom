import 'dart:io';
import 'dart:math';

final Map<String, List<String>> romajiToHiragana = {
  "a": ["あ"],
  "i": ["い"],
  "u": ["う"],
  "e": ["え"],
  "o": ["お"],
  "ka": ["か"],
  "ki": ["き"],
  "ku": ["く"],
  "ke": ["け"],
  "ko": ["こ"],
  "sa": ["さ"],
  "shi": ["し"],
  "su": ["す"],
  "se": ["せ"],
  "so": ["そ"],
  "ta": ["た"],
  "chi": ["ち"],
  "tsu": ["つ"],
  "te": ["て"],
  "to": ["と"],
  "na": ["な"],
  "ni": ["に"],
  "nu": ["ぬ"],
  "ne": ["ね"],
  "no": ["の"],
  "ha": ["は"],
  "hi": ["ひ"],
  "fu": ["ふ"],
  "he": ["へ"],
  "ho": ["ほ"],
  "ma": ["ま"],
  "mi": ["み"],
  "mu": ["む"],
  "me": ["め"],
  "mo": ["も"],
  "ya": ["や"],
  "yu": ["ゆ"],
  "yo": ["よ"],
  "ra": ["ら"],
  "ri": ["り"],
  "ru": ["る"],
  "re": ["れ"],
  "ro": ["ろ"],
  "wa": ["わ"],
  "wo": ["を"],
  "n": ["ん"],
  "ga": ["が"],
  "gi": ["ぎ"],
  "gu": ["ぐ"],
  "ge": ["げ"],
  "go": ["ご"],
  "za": ["ざ"],
  "ji": ["じ", "ぢ"],
  "zu": ["ず", "づ"],
  "ze": ["ぜ"],
  "zo": ["ぞ"],
  "da": ["だ"],
  "de": ["で"],
  "do": ["ど"],
  "ba": ["ば"],
  "bi": ["び"],
  "bu": ["ぶ"],
  "be": ["べ"],
  "bo": ["ぼ"],
  "pa": ["ぱ"],
  "pi": ["ぴ"],
  "pu": ["ぷ"],
  "pe": ["ぺ"],
  "po": ["ぽ"],
  "kya": ["きゃ"],
  "kyu": ["きゅ"],
  "kyo": ["きょ"],
  "sha": ["しゃ"],
  "shu": ["しゅ"],
  "sho": ["しょ"],
  "cha": ["ちゃ"],
  "chu": ["ちゅ"],
  "cho": ["ちょ"],
  "nya": ["にゃ"],
  "nyu": ["にゅ"],
  "nyo": ["にょ"],
  "hya": ["ひゃ"],
  "hyu": ["ひゅ"],
  "hyo": ["ひょ"],
  "mya": ["みゃ"],
  "myu": ["みゅ"],
  "myo": ["みょ"],
  "rya": ["りゃ"],
  "ryu": ["りゅ"],
  "ryo": ["りょ"],
};

final Map<String, List<String>> romajiToKatakana = {
  "a": ["ア"],
  "i": ["イ"],
  "u": ["ウ"],
  "e": ["エ"],
  "o": ["オ"],
  "ka": ["カ"],
  "ki": ["キ"],
  "ku": ["ク"],
  "ke": ["ケ"],
  "ko": ["コ"],
  "sa": ["サ"],
  "shi": ["シ"],
  "su": ["ス"],
  "se": ["セ"],
  "so": ["ソ"],
  "ta": ["タ"],
  "chi": ["チ"],
  "tsu": ["ツ"],
  "te": ["テ"],
  "to": ["ト"],
  "na": ["ナ"],
  "ni": ["ニ"],
  "nu": ["ヌ"],
  "ne": ["ネ"],
  "no": ["ノ"],
  "ha": ["ハ"],
  "hi": ["ヒ"],
  "fu": ["フ"],
  "he": ["ヘ"],
  "ho": ["ホ"],
  "ma": ["マ"],
  "mi": ["ミ"],
  "mu": ["ム"],
  "me": ["メ"],
  "mo": ["モ"],
  "ya": ["ヤ"],
  "yu": ["ユ"],
  "yo": ["ヨ"],
  "ra": ["ラ"],
  "ri": ["リ"],
  "ru": ["ル"],
  "re": ["レ"],
  "ro": ["ロ"],
  "wa": ["ワ"],
  "wo": ["ヲ"],
  "n": ["ン"],
  "ga": ["ガ"],
  "gi": ["ギ"],
  "gu": ["グ"],
  "ge": ["ゲ"],
  "go": ["ゴ"],
  "za": ["ザ"],
  "ji": ["ジ", "ヂ"],
  "zu": ["ズ", "ヅ"],
  "ze": ["ゼ"],
  "zo": ["ゾ"],
  "da": ["ダ"],
  "de": ["デ"],
  "do": ["ド"],
  "ba": ["バ"],
  "bi": ["ビ"],
  "bu": ["ブ"],
  "be": ["ベ"],
  "bo": ["ボ"],
  "pa": ["パ"],
  "pi": ["ピ"],
  "pu": ["プ"],
  "pe": ["ペ"],
  "po": ["ポ"],
  "kya": ["キャ"],
  "kyu": ["キュ"],
  "kyo": ["キョ"],
  "sha": ["シャ"],
  "shu": ["シュ"],
  "sho": ["ショ"],
  "cha": ["チャ"],
  "chu": ["チュ"],
  "cho": ["チョ"],
  "nya": ["ニャ"],
  "nyu": ["ニュ"],
  "nyo": ["ニョ"],
  "hya": ["ヒャ"],
  "hyu": ["ヒュ"],
  "hyo": ["ヒョ"],
  "mya": ["ミャ"],
  "myu": ["ミュ"],
  "myo": ["ミョ"],
  "rya": ["リャ"],
  "ryu": ["リュ"],
  "ryo": ["リョ"],
};

// extension RomajiExtension on String {
//   String toHiragana() {
//     return romajiToHiragana[this]?.first ?? 'Sílaba desconhecida';
//   }

//   String toKatakana() {
//     return romajiToKatakana[this]?.first ?? 'Sílaba desconhecida';
//   }
// }

extension RomajiExtension on String {
  String toHiragana() {
    Random random = Random();
    List<String>? hiraganaList = romajiToHiragana[this];
    if (hiraganaList != null && hiraganaList.isNotEmpty) {
      return hiraganaList[random.nextInt(hiraganaList.length)];
    } else {
      return 'Sílaba desconhecida';
    }
  }

  String toKatakana() {
    Random random = Random();
    List<String>? katakanaList = romajiToKatakana[this];
    if (katakanaList != null && katakanaList.isNotEmpty) {
      return katakanaList[random.nextInt(katakanaList.length)];
    } else {
      return 'Sílaba desconhecida';
    }
  }
}

int getUserChoice() {
  print('Escolha o modo: \n1. Hiragana \n2. Katakana \n3. Hiragana/Katakana');
  String? choiceInput = stdin.readLineSync();
  int choice = int.tryParse(choiceInput ?? '') ?? 3;

  return choice;
}

void playARound(Random random, int choice) {
  bool isHiragana = choice == 1 || (choice == 3 && random.nextBool());
  Map<String, List<String>> selectedMap =
      isHiragana ? romajiToHiragana : romajiToKatakana;

  String randomKey =
      selectedMap.keys.elementAt(random.nextInt(selectedMap.length));
  String displayedCharacter =
      isHiragana ? randomKey.toHiragana() : randomKey.toKatakana();

  print(
      'Qual é o Romaji para ${isHiragana ? 'Hiragana' : 'Katakana'}: $displayedCharacter ?');
  String? userResponse = stdin.readLineSync();

  if (userResponse != null && userResponse.toLowerCase() == randomKey) {
    print('Correto!');
  } else {
    print('Errado. A resposta correta é: $randomKey');
  }
}

bool wantsToContinue() {
  print('Deseja continuar? (s/n)');
  return stdin.readLineSync()?.toLowerCase() == 's';
}

void testYotsugana() {
  print("ji".toHiragana());
  print("zu".toHiragana());
  print("ji".toKatakana());
  print("zu".toKatakana());
}

void main() {
  // testYotsugana();

  Random random = Random();
  int choice = getUserChoice();

  do {
    playARound(random, choice);
  } while (wantsToContinue());
}
