import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { withRouter } from "react-router-dom";
import Header from "../../../components/common/Header/Header";
import { logout } from "../../../modules/user";

const HeaderContainer = ({ history }) => {
  const { user } = useSelector(({ user }) => ({ user: user.user }));
  const dispatch = useDispatch();
  const onLogout = () => {
    dispatch(logout());
  };

  // user 값이 없다면 로그인 화면으로
  useEffect(() => {
    if (!user) {
      console.log("잘못된 접근입니다.");
      history.push("/"); // 로그인 페이지로 이동
    }
  }, [history, user]);

  return <Header user={user} onLogout={onLogout} />;
};

export default withRouter(HeaderContainer);
