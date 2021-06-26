import React from "react";
import styles from "./Header.scss";
import classNames from "classnames/bind";
import { Link } from "react-router-dom";

const cx = classNames.bind(styles);

const Header = () => {
  return (
    <div className={cx("header-container")}>
      <header>
        <h1>
          <Link to="/">CareerUS</Link>
        </h1>
      </header>
    </div>
  );
};

export default Header;
