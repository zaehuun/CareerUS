import React from "react";
import PageTemplate from "../components/common/PageTemplate/PageTemplate";
import HeaderContainer from "../containers/common/Header/HeaderContainer";
import FooterContainer from "../containers/common/Footer/FooterContainer";
import PostListContainer from "../containers/Posts/PostListContainer";

const PostListPage = () => {
  return (
    <PageTemplate>
      <HeaderContainer />
      <PostListContainer />
      <FooterContainer />
    </PageTemplate>
  );
};

export default PostListPage;
