import React from "react";
import PageTemplate from "../components/common/PageTemplate/PageTemplate";
import HeaderContainer from "../containers/common/Header/HeaderContainer";
import WriteContainer from "../containers/Write/WriteContainer";
import FooterContainer from "../containers/common/Footer/FooterContainer";
import WriteActionButtons from "../components/Write/WriteActionButtons";
import TagBoxContainer from "../containers/Write/TagBoxContainer";

const WritePage = () => {
  return (
    <PageTemplate>
      <HeaderContainer />
      <WriteContainer />
      <TagBoxContainer />
      <WriteActionButtons />
      <FooterContainer />
    </PageTemplate>
  );
};

export default WritePage;
