import React, { useEffect } from "react";
import qs from "qs";
import { useDispatch, useSelector } from "react-redux";
import { withRouter } from "react-router-dom";
import PostViewer from "../../components/Post/PostViewer";
import { readPost, unloadPost } from "../../modules/post";

const PostViewerContainer = ({ location }) => {
  // 처음 마운트될 때 포스트 읽기 API 요청
  // const { postId } = match.params;
  const dispatch = useDispatch();
  const { post, error, loading } = useSelector(({ post, loading }) => ({
    post: post.post,
    error: post.error,
    loading: loading["post/READ_POST"],
  }));

  useEffect(() => {
    const { postid } = qs.parse(location.search, {
      ignoreQueryPrefix: true,
    });
    dispatch(readPost(postid));
    // 언마운트될 때 리덕스에서 포스트 데이터 없애기
    return () => {
      dispatch(unloadPost());
    };
  }, [dispatch, location.search]);

  return <PostViewer post={post} loading={loading} error={error} />;
};

export default withRouter(PostViewerContainer);
