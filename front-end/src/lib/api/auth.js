import client from "./client";

// 로그인
export const login = ({ username, password }) =>
  client.post("/login", { username, password });

// 회원가입
export const register = ({
  username,
  password,
  passwordConfirm,
  registerCode,
  name,
  comment,
}) =>
  client.post("/register", {
    username,
    password,
    passwordConfirm,
    registerCode,
    name,
    comment,
  });
