import React, { useState, useCallback } from "react";
import styles from "./TagBox.scss";
import classNames from "classnames/bind";

const cx = classNames.bind(styles);

// tag 값이 바뀔 때만 리렌더링되도록 처리
const TagItem = React.memo(({ tag, onRemove }) => (
  <div className={cx("tag")} onClick={() => onRemove(tag)}>
    #{tag}
  </div>
));

// tags 값이 바뀔 때만 리렌더링되도록 처리
const TagList = React.memo(({ tags, onRemove }) => (
  <div className={cx("tagbox-list")}>
    {tags.map((tag) => (
      <TagItem key={tag} tag={tag} onRemove={onRemove} />
    ))}
  </div>
));

const TagBox = () => {
  const [input, setInput] = useState("");
  const [localTags, setLocalTags] = useState([]);

  const insertTag = useCallback(
    (tag) => {
      if (!tag) return; // 공백이라면 추가하지 않음
      if (localTags.includes(tag)) return; // 이미 존재한다면 추가하지 않음
      setLocalTags([...localTags, tag]);
    },
    [localTags]
  );

  const onRemove = useCallback(
    (tag) => {
      setLocalTags(localTags.filter((t) => t !== tag));
    },
    [localTags]
  );

  const onChange = useCallback((e) => {
    setInput(e.target.value);
  }, []);

  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      insertTag(input.trim()); // 앞뒤 공백을 없앤 후 등록
      setInput(""); // input 초기화
    },
    [input, insertTag]
  );

  return (
    <div className={cx("tagbox-container")}>
      <h4>태그</h4>
      <form className={cx("tagbox-form")} onSubmit={onSubmit}>
        <input
          placeholder="태그를 입력하세요"
          value={input}
          onChange={onChange}
        />
        <button type="submit">추가</button>
      </form>
      <TagList tags={localTags} onRemove={onRemove} />
    </div>
  );
};

export default TagBox;
