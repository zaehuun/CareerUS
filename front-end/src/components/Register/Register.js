import React from "react";
import styles from "./Register.scss";
import classNames from "classnames/bind";
import { Link } from "react-router-dom";

const cx = classNames.bind(styles);

const Register = ({ form, onChange, onSubmit }) => {
  return (
    <div className={cx("register-container")}>
      <div className={cx("register-box")}>
        <header>
          <h1>
            <Link to="/login">CareerUS</Link>
          </h1>
        </header>
        <main>
          <div id="content">
            <form onSubmit={onSubmit}>
              <h3 className="hide">회원가입</h3>
              {/* 아이디, 비밀번호, 가입코드 그룹 */}
              <div className={cx("row-group")}>
                {/* 아이디 입력 */}
                <div className={cx("join-row")}>
                  <h3 className={cx("join-title")}>아이디</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="username"
                        placeholder="아이디"
                        autoComplete="off"
                        onChange={onChange}
                        value={form.username}
                      />
                    </span>
                  </div>
                  <span className={cx("error-next-box")}>
                    필수 정보입니다. 5~20자의 영문 소문자, 숫자와
                    특수기호(_),(-)만 사용 가능합니다.
                  </span>
                </div>
                {/* 비밀번호 입력 */}
                <div className={cx("join-row")}>
                  <h3 className={cx("join-title")}>비밀번호</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="password"
                        placeholder="비밀번호"
                        autoComplete="off"
                        onChange={onChange}
                        value={form.password}
                      />
                    </span>
                    <span className={cx("input-pw")}></span>
                  </div>
                  <span className={cx("error-next-box")}>
                    8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
                  </span>
                  {/* 비밀번호 재확인 입력 */}
                  <h3 className={cx("join-title")}>비밀번호 재확인</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="passwordConfirm"
                        placeholder="비밀번호 재확인"
                        autoComplete="off"
                        onChange={onChange}
                        value={form.passwordConfirm}
                      />
                    </span>
                    <span className={cx("input-pw")}></span>
                  </div>
                  <span className={cx("error-next-box")}>
                    비밀번호가 일치하지 않습니다.
                  </span>
                </div>
                {/* 가입코드 입력 */}
                <div className={cx("join-row")}>
                  <h3 className={cx("join-title")}>가입코드</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="registerCode"
                        placeholder="가입코드"
                        autoComplete="off"
                        onChange={onChange}
                        value={form.registerCode}
                      />
                    </span>
                    <span className={cx("input-pw")}></span>
                  </div>
                  <span className={cx("error-next-box")}>
                    가입코드가 일치하지 않습니다.
                  </span>
                </div>
              </div>
              {/* 유저정보 그룹 */}
              <div className={cx("row-group")}>
                {/* 이름 입력 */}
                <div className={cx("join-row")}>
                  <h3 className={cx("join-title")}>이름</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="name"
                        placeholder="이름"
                        autoComplete="off"
                        onChange={onChange}
                        value={form.name}
                      />
                    </span>
                    <span className={cx("input-pw")}></span>
                  </div>
                  <span className={cx("error-next-box")}>
                    한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용
                    불가)
                  </span>
                </div>
                {/* 소개글 입력 */}
                <div className={cx("join-row")}>
                  <h3 className={cx("join-title")}>소개글</h3>
                  <div className={cx("input-wrap")}>
                    <span className={cx("input-box")}>
                      <input
                        type="text"
                        className={cx("int")}
                        name="comment"
                        placeholder="행복하게 여행하려면 가볍게 여행해야 한다."
                        autoComplete="off"
                        onChange={onChange}
                        value={form.comment}
                      />
                    </span>
                    <span className={cx("input-pw")}></span>
                  </div>
                  <span className={cx("error-next-box")}>
                    한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용
                    불가)
                  </span>
                </div>
              </div>
              <button className={cx("login-button")}>가입하기</button>
            </form>
          </div>
        </main>
      </div>
    </div>
  );
};

export default Register;
