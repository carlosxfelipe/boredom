const robot = require("robotjs");
const sin = Math.sin;
const PI = Math.PI;

const screenSize = robot.getScreenSize();
const width = screenSize.width;
const height = screenSize.height / 2 - 10;
let x = 0;

console.log("Por quantos minutos você quer que o mouse se mova?");
process.stdin.on("data", function (data) {
  const minutes = parseInt(data.toString(), 10);
  const endTime = Date.now() + minutes * 60000;

  function moveMouse() {
    if (Date.now() >= endTime) {
      process.exit();
    }

    if (x > width) {
      x = 0;
    }
    for (let i = 0; i < width; i++) {
      const y = height * sin((2 * PI * i) / width) + height;
      robot.moveMouse(i, Math.round(y));
      robot.setMouseDelay(10);
    }
    x++;
  }

  setInterval(moveMouse, 10);
});
