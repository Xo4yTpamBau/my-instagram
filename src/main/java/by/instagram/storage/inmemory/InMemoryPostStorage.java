package by.instagram.storage.inmemory;

//public class InMemoryPostStorage implements PostStorage {
//    private static final List<Post> posts = new ArrayList<>();
//    private static long incId = 1;
//
//
//    private void incrementId(Post post) {
//        post.setId(incId++);
//    }
//
//
//    @Override
//    public void view(long id) {
//
//    }
//
//    @Override
//    public void save(Post post) {
//        incrementId(post);
//        posts.add(post);
//
//    }
//
//    @Override
//    public void saveLikeToPost(long idLike, long idPost) {
//
//    }
//
//    @Override
//    public void saveCommentToPost(long idComment, long idPost) {
//
//    }
//
//    @Override
//    public List<Post> getAll() {
//        return new ArrayList<>(posts);
//    }
//
//    @Override
//    public Post getById(long id) {
//        for (Post post : posts) {
//            if (post.getId() == id) {
//                return post;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean containsByLIkeUser(Post post, User user) {
//        for (Like like : post.getLikes()) {
//            if (like.getUser().equals(user)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public List<Post> getAllByApprove() {
////        return posts.stream().filter(Post::isApprove).collect(Collectors.toList());
//        List<Post> approvePost = new ArrayList<>();
//        for (Post post : posts) {
//            if (post.isApprove()) {
//                approvePost.add(post);
//            }
//        }
//        return approvePost;
//    }
//
//    @Override
//    public List<Post> getAllByNotApprove() {
//        List<Post> approvePost = new ArrayList<>();
//        for (Post post : posts) {
//            if (!(post.isApprove())) {
//                approvePost.add(post);
//            }
//        }
//        return approvePost;
//    }
//
//    @Override
//    public List<Post> getAllByUser(User user) {
//        List<Post> allPostUser = new ArrayList<>();
//        for (Post post : posts) {
//            if (post.getUser().equals(user)) {
//                allPostUser.add(post);
//            }
//        }
//        return allPostUser;
//    }
//
//    @Override
//    public void approvePost(long id) {
//        for (Post post : posts) {
//            if (post.getId() == id){
//                post.setApprove(true);
//            }
//        }
//    }
//
//    @Override
//    public void deleteById(long id) {
//        for (Post post : posts) {
//            if (post.getId() == id){
//                posts.remove(post);
//                break;
//            }
//        }
//    }
//
//
//}
