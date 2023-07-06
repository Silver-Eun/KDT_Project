'use strict';

const idx = '012345678901234567890';
const str = 'both ends of a String';

/*
string.startsWith( searchString: string, position?: number ): boolean
string.endsWith( searchString: string, position?: number ): boolean
-   대상 문자열이 검색문자열(searchString)로 시작(startsWith)하거나 끝(endsWith)나는지 여부 반환.
    추가 인수 position을 통해 검색 시작 위치 결정.

string.includes( searchString: string, position?: number ): boolean
-   대상 문자열에 검색문자열(searchString)이 포함되어 있는지 여부 반환.
    추가 인수 position 통해 검색 시작 위치 결정.
*/

// console.log(str.startsWith('both'));
// console.log(str.startsWith('ends'));
// console.log(str.startsWith('ends', 5));
// console.log(str.endsWith('String'));
// console.log(str.includes('of'));
// console.log(str.includes('String'));
// console.log();


// 배열 연산자와 charAt은 기능상 동일하지만, 배열 연산자는 해당 인덱스에 문자가
// 존재하지 않으면 undefined를 반환하는 반면 charAt은 빈 문자열('')을 반환.
// console.log(str[50]);
// console.log(str.charAt(50));
// console.log('=========');


// 배열 접근시 사용하는 for ~ of를 문자열에도 동일 적용 가능.
// for (const ch of str) {
//     console.log(ch);
// }
// console.log();


/*
indexOf( searchString: string, position?: number ): number
-   substring은 인덱스를 지정해 해당 위치의 부분 문자열을 반환받는 반면, indexOf는 문자열을 지정해 검색되는
    문자열의 최초 해당 인덱스를 반환. 검색 시작 위치(position)를 추가로 지정 가능하며 검색 실패시 -1 반환.
    단, 최초 검색되는 문자열에 대응되는 인덱스만 반환할 뿐 매칭된 모든 문자열의 인덱스를 반환하는 것은
    아님에 주의.

lastIndexOf( searchString: string, position?: number): number
-   indexOf와 기능상 동일하되 역순 검색.
*/

// console.log(str.indexOf('t'));
// console.log(str.indexOf('o'));
// console.log(str.indexOf('t', 5));
// console.log(str.indexOf('a'));
// console.log(str.lastIndexOf('a', 16));
// console.log();


/* indexOf 활용 반복되는 문자열 검색. */
// for (let ix = 0, findIx; ;) {
//     findIx = str.indexOf('a', ix);
//     if (findIx == -1) break;

//     console.log(findIx);
//     ix = findIx + 1;
// }
// console.log()

/*
< indexOf 활용 반복되는 문자열 검색 단축 코드>
-   단, 연산 우선 순위에 주의.
    대입(할당) 연산자(=) 보다 비교 연산자(!=)가 우선 순위가 더 높아 할당 연산( ix = str.indexOf('t', ix + 1) )을
    먼저하지 않으면, 비교 연산( str.indexOf('t', ix + 1)) != -1 )이 우선 적용되어 검색되는 값이 존재하면 대입되지
    않고 루프로 바로 진입되어 무한 루프 발생 가능.
*/

// for (let ix = -1; (ix = str.indexOf('a', ix + 1)) != -1;) console.log(ix);
// console.log()


/*
string.codePointAt( pos: number ): number
-   해당 문자열에서 pos에 해당하는 인덱스 위치값에 대한 유니코드 값 반환.
    js에서의 모든 문자열은 UTF-16형식으로 인코딩.
    ( 구버젼 메서드 - charCodeAt )
*/

// 인수(pos) 미 지정시 디폴트 0.
// console.log('s'.codePointAt());
// console.log('ABC'.codePointAt(1));
// console.log('c'.codePointAt());
// console.log('abc'.codePointAt(1));
// console.log('--------------------------');


/*
(구버젼)String.fromCharCode( ...codes: number[] ): string
- 인수로 지정한 유니코드 값들에 대응되는 문자열을 반환.
  ... 은 다중 인수 지정이 가능함을 의미.

String.fromCodePoint( ...codePoints: number[] ): string
- fromCharCode와 동작이 동일하지만 fromCharCode는 서로게이트 쌍을 처리 못하지만,
  fromCodePoint는 보다 최신에 나온 메서드로 서로게이트 쌍을 처리 가능.

※ 서로게이트 쌍 : 2바이트로 표현되는 유니코드의 범위의 한계로 인해 사용빈도가 낮은 특수 문자들에
                   대하여 2바이트 쌍(4byte)으로 인코딩하여 표현.
*/
// 구버젼
// console.log(String.fromCharCode(65));
// console.log(String.fromCharCode(97, 98));
// 신버젼
// console.log(String.fromCodePoint(65));
// console.log(String.fromCodePoint(97, 98));
// console.log('--------------------------');


/*
codePointAt, fromCodePoint 메서드를 이용한 대소문자 변환.
- js에서는 자바와 같이 'a' - 'A' 같은 연산 시 내부적으로 숫자로 평가되어
  연산되지는 않고 NaN 결과값 도출.
*/
// const dis = 'a'.codePointAt() - 'A'.codePointAt();

// 입력 문자로 가정.
// let input = 't';
// let lowerCode = input.codePointAt();

// console.log(String.fromCodePoint(lowerCode - dis));
// console.log('--------------------------');

console.clear();