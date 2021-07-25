import qs from "qs";
import client from "./client";

export const writePost = ({ title, body, tags }) =>
  client.post("/api/posts", { title, body, tags });

export const readPost = (id) => client.get(`/api/posts/${id}`);

export const listPosts = ({ limit, page, username, tag }) => {
  const queryString = qs.stringify({
    limit,
    page,
    username,
    tag,
  });

  return client.get(`/api/posts?${queryString}`);
};
