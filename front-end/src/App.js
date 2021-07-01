import React from "react";
import { Route, Switch } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import MainPage from "./pages/MainPage";
import NotFoundPage from "./pages/NotFoundPage";
// import PostListPage from "./pages/PostListPage";
// import WritePage from "./pages/WritePage";
// import PostPage from "./pages/PostPage";

const App = () => {
  return (
    <>
      <Switch>
        <Route component={LoginPage} path="/" exact={true} />
        <Route component={LoginPage} path="/login" />
        <Route component={MainPage} path="/main" />
        <Route component={RegisterPage} path="/register" />
        <Route component={NotFoundPage} />
        {/* <Route component={PostListPage} path="/@:username" />
      <Route component={WritePage} path="/write" />
      <Route component={PostPage} path="/@:username/:postId" /> */}
      </Switch>
    </>
  );
};

export default App;
