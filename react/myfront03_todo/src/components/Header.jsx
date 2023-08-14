import "./Header.css";
import React from "react";

const Header = () => {
  console.log("** Header Update !! **");
  return (
    <div className="Header">
      <h3>오늘은 📅</h3>
      {/* => 윈도우 이모지 : 윈도우+ .  누르면 표시됨 */}
      <h1>{new Date().toDateString()}</h1>
      {/* => toDateString() :  날짜를 문자열로 */}
    </div>
  );
};

export default React.memo(Header);
