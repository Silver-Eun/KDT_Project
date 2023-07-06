'use strict';

const str1 = '   Removes Whitespace   from\n';
const str2 = 'both ends of a String';

/*
string.trim(): string
- 문자열 양쪽 끝의 공백을 제거한 새로운 문자열을 반환. 여기서 공백은 space, tab, NBSP, 개행문자(\n).
*/
// console.log(str1);
// console.log(str1.trim());
// console.log(str1.trim() + str2);
// console.log();


/*
string.trimStart(): string
- 문자열의 처음 공백을 제거한 새로운 문자열을 반환.

string.trimEnd(): string
- 문자열의 끝 공백을 제거한 새로운 문자열을 반환.
*/

// console.log(str1.trimStart() + str2);
// console.log(str1.trimEnd() + str2);
// console.log();


/*
string.toLowerCase(): string
- 모든 문자열을 소문자로 변환한 새로운 문자열 반환.

string.toUpperCase(): string
- 모든 문자열을 대문자로 변환한 새로운 문자열 반환

string.repeat( count: number ): string
- 해당 문자열을 count만큼 재생한 새로운 문자열 반환.
*/

// console.log(str1.toLowerCase());
// console.log(str1.toUpperCase());
// console.log(str1.repeat(3));
// console.log();


/*
string.substring( startIndex: number, endIndex?: number ): string
-   시작인덱스(startIndex) 부터 종료인덱스(endIndex) 전까지의 새로운 부분 문자열 반환.
    종료인덱스를 생략하면 시작인덱스부터 문자열 끝까지 추출되며, 종료인덱스 위치의 문자는
    포함되지 않음에 주의. 시작인덱스가 종료인덱스 보다 큰 경우도 허용되는데, 이 경우 내부적으로
    시작인덱스와 종료인덱스를 서로 치환하여 시작인덱스가 종료인덱스 보다 작도록 처리.
    시작 인덱스가 인덱스 범위를 벗어난 경우 빈 문자열 반환.

string.slice( startIndex: number, endIndex?: number ): string
-   substring와 사용 방법이 거의 동일. 단, 음수 인덱싱이 가능하고 시작인덱스가 종료인덱스 보다 큰 경우
    빈 문자열('')을 반환한다는 차이.
    시작 인덱스가 인덱스 범위를 벗어난 경우 빈 문자열 반환.
*/

// console.log(str2.substring(5));
// console.log(str2.substring(5, 8));
// 시작인덱스가 종료인덱스 보다 큰 경우이므로 내부적으로
// 다시 start가 5가 되고 end가 8이 되도록 서로 치환.
// console.log(str2.substring(8, 5));
// console.log();

// console.log(str2.slice(5, 8));
// 시작인덱스가 종료인덱스 보다 큰 경우 빈 문자열 반환.
// console.log(str2.slice(8, 5));
// console.log(str2.slice(-6));
// console.log();

/*
String.replace(searchValue: string | RegExp, replaceValue: string): string
-   대응되는 최초 문자열(searchValue)을 검색하여 다른 문자열(replaceValue)로 치환한 새로운 문자열을
    반환(원본 문자열은 유지). 대응되는 부분이 없으면 원본 문자열 그대로 반환.
    전체적인 검색은 정규식을 이용한 별도 g 플래그를 이용해야만 가능.

String.split(separator: string | RegExp, limit?: number): string[]
-   대상 문자열을 지정된 구분자(Separator)로 나누어 구분자로 분리된 문자열들을 배열 형태로
    반환. 구분자는 문자열 또는 정규식으로 지정 가능하며 제한자(limit)를 두어 반환받을 배열의
    요소를 제한 가능. 인수를 모두 생략하면 전체 문자열이 하나의 배열 요소로 반환.
*/

// const str3 = 'replaces the matched substring with a replacement substring.';

// console.log(str3.replace('sub', 'main'));
// console.log(str3);
// console.log(str3.replace('middle', 'center'));
// console.log();


const str4 = 'Uses a regular expression';

// 인수를 모두 생략하면 전체 문자열이 하나의 배열 요소로 반환.
// console.log(str4.split());

// 구분자를 빈 문자열로 지정하면 대상 문자열의 모든 문자들을 배열 요소들로 반환.
// console.log(str4.split(''));

// 제한자 인수를 두어 반환 배열 요소들을 제한.
// console.log(str4.split('', 4));
// console.log();

// console.log(str4.split(' '));
// console.log(str4.split(' ', 2));
// 구분자를 통해 반환받은 배열을 통한 인덱싱.
// console.log(str4.split(' ')[3]);
// console.log();


//  length : 문자열의 길이를 조사하는 속성(property).
// console.log(str4.length);