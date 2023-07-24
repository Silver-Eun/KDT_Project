let menu = "짜장";
// console.log(`** foo.js menu = ${window.menu}`);
console.log(`** foo.mjs menu = ${menu}`);

// ** import 1)
// import { pi, square, Person } from "./230724_m02_bar.mjs";

// console.log(`** foo import 확인 foo.mjs pi = ${pi}`);
// console.log(`** foo import 확인 foo.mjs square(5) = ${square(5)}`);
// console.log(new Person("Lee")); // Person{ name : 'Lee' }

// import 2)
// => myLib를 통해 접근
// import * as myLib from "./230724_m02_bar.mjs";
// console.log(`** foo import 확인 foo.mjs pi = ${myLib.pi}`);
// console.log(`** foo import 확인 foo.mjs square(5) = ${myLib.square(5)}`);
// console.log(new myLib.Person("Lee")); // Person{ name : 'Lee' }

// import 3)
// => export한 식별자 이름을 변경하여 import
import {
  pi as PI,
  square as mySquare,
  Person as P,
} from "./230724_m02_bar.mjs";
console.log(`** foo import 확인 foo.mjs pi = ${PI}`);
console.log(`** foo import 확인 foo.mjs square(5) = ${mySquare(5)}`);
console.log(new P("Lee")); // Person{ name : 'Lee' }
