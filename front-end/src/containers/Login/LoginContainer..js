import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import Login from "../../components/Login/Login";
import { changeField, initializeForm } from "../../modules/auth";

const LoginContainer = () => {
  const dispatch = useDispatch();
  const { form } = useSelector(({ auth }) => ({
    form: auth.login,
  }));

  // input 변경 이벤트 핸들러
  const onChange = (e) => {
    const { value, name } = e.target;
    dispatch(
      changeField({
        form: "login",
        key: name,
        value,
      })
    );
  };

  // form submit 이벤트 핸들러
  const onSubmit = (e) => {
    e.preventDefault();
    // 구현 예정
  };

  // 컴포넌트가 처음 렌더링될 때 form을 초기화함
  useEffect(() => {
    dispatch(initializeForm("login"));
  }, [dispatch]);

  return <Login form={form} onChange={onChange} onSubmit={onSubmit} />;
};

export default LoginContainer;
