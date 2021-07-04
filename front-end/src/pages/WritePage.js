import React from "react";
import PageTemplate from "../components/common/PageTemplate/PageTemplate";
import HeaderContainer from "../containers/common/Header/HeaderContainer";
import WriteContainer from "../containers/Write/WriteContainer";
import FooterContainer from "../containers/common/Footer/FooterContainer";

const WritePage = () => {
  return (
    <PageTemplate>
      <HeaderContainer />
      <WriteContainer />
      <FooterContainer />
    </PageTemplate>
  );
};

export default WritePage;
