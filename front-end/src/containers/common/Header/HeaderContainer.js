import React from "react";
import { useSelector } from "react-redux";
import Header from "../../../components/common/Header/Header";

const HeaderContainer = () => {
  const { auth } = useSelector(({ auth }) => ({ auth: auth.auth }));
  return <Header auth={auth} />;
};

export default HeaderContainer;
