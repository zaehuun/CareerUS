import React from "react";
import { Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import MainPage from "./pages/MainPage";
// import PostListPage from "./pages/PostListPage";
// import WritePage from "./pages/WritePage";
// import PostPage from "./pages/PostPage";

const App = () => {
  return (
    <>
      <Route component={MainPage} path="/" exact={true} />
      <Route component={LoginPage} path="/login" />
      <Route component={RegisterPage} path="/register" />
      {/* <Route component={PostListPage} path="/@:username" />
      <Route component={WritePage} path="/write" />
      <Route component={PostPage} path="/@:username/:postId" /> */}
    </>
  );
};

export default App;
