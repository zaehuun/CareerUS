import React from "react";
import styles from "./Footer.scss";
import classNames from "classnames/bind";
import { Link } from "react-router-dom";

const cx = classNames.bind(styles);

const Footer = () => {
  return (
    <div className={cx("footer-container")}>
      <footer>
        <h1>푸터</h1>
      </footer>
    </div>
  );
};

export default Footer;
