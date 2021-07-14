import React, { useEffect } from "react";
import WriteActionButtons from "../../components/Write/WriteActionButtons";
import { useDispatch, useSelector } from "react-redux";
import { withRouter } from "react-router";
import { writePost } from "../../modules/write";

const WriteActionButtonsContainer = ({ history }) => {
  const dispatch = useDispatch();
  const { title, body, tags, post, postError } = useSelector(({ write }) => ({
    title: write.title,
    body: write.body,
    tags: write.tags,
    post: write.post,
    postError: write.postError,
  }));

  // 포스트 등록
  const onPublish = () => {
    dispatch(
      writePost({
        title,
        body,
        tags,
      })
    );
  };

  // 취소
  const onCancel = () => {
    history.goBack();
  };

  // 성공 혹은 실패 시 할 작업
  useEffect(() => {
    if (post) {
      const { _id, user } = post;
      history.push(`/board/view/${user.username}/${_id}`);
    }
    if (postError) {
      console.log(postError);
      alert("포스트 등록에 실패했습니다.");
    }
  }, [history, post, postError]);

  return <WriteActionButtons onPublish={onPublish} onCancel={onCancel} />;
};

export default withRouter(WriteActionButtonsContainer);
