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
      <Route component={LoginPage} path={["/", "/login"]} exact={true} />
      <Route component={MainPage} path="/main" />
      <Route component={RegisterPage} path="/register" />
      {/* <Route component={PostListPage} path="/@:username" />
      <Route component={WritePage} path="/write" />
      <Route component={PostPage} path="/@:username/:postId" /> */}
    </>
  );
};

export default App;
