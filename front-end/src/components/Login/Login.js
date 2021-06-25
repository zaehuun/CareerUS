import React from "react";
import styles from "./Login.scss";
import classNames from "classnames/bind";
import { Link } from "react-router-dom";

const cx = classNames.bind(styles);

const Login = () => {
  return (
    <div className={cx("login-container")}>
      <header>
        <h1>
          <Link to="/login">CareerUS</Link>
        </h1>
      </header>
      <main>
        <div id="content">
          <form>
            <h3 className="hide">로그인</h3>
            <div className={cx("input-wrap")}>
              <span className={cx("input-box")}>
                <input
                  type="text"
                  className={cx("int")}
                  name="username"
                  placeholder="아이디"
                  autoComplete="off"
                />
              </span>
            </div>
            <div className={cx("input-wrap")}>
              <span className={cx("input-box")}>
                <input
                  type="password"
                  className={cx("int")}
                  name="password"
                  placeholder="비밀번호"
                  autoComplete="off"
                />
              </span>
            </div>
            <div className={cx("login-error-message")}>에러발생!</div>
            <button className={cx("login-button")}>로그인</button>
          </form>
        </div>
      </main>
    </div>
  );
};

export default Login;
