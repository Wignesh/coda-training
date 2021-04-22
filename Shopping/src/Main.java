import ga.veee.shopping.Entity.ItemMaster;
import ga.veee.shopping.Repository.ItemMasterRepository;
import ga.veee.shopping.Repository.UserRepository;


public class Main {


    public static void main(final String[] args) throws Exception {
        ItemMasterRepository userRepository = ItemMasterRepository.getRepository();
        System.out.println(userRepository.insert(new ItemMaster("TOMOTO", 12.2, "VEG", "1 KG", "https://i.stack.imgur.com/XgeJ5.png?s=32&g=1")));
//        System.out.println(userRepository.insert(new User("vignesh1", "Vignesh@123")));
        System.out.println(userRepository.count());
//        System.out.println(userRepository.findById(15));
//        System.out.println(userRepository.insertAll(List.of(new User("vj", "vj@123"), new User("jv", "jv@123"))));
//        Optional<User> user = userRepository.findById(1);
//        User user1 = user.orElse(null);
//        System.out.println(userRepo.findAll());
//
//        System.out.println(userRepository.findById(1));
//        userEntity.setUserName("Bob");
//        System.out.println(;
//        System.out.println(userRepository.insert(userEntity));
//        userEntity = user.find(14).get();
//        System.out.println(userEntity);

//        method("");
//        try (Session session = HibernateUtility.getSession()) {
//            final Query query = session.createQuery("from UserEntity ");
//            for (Object o : query.list()) {
//                System.out.println("  " + o);
//            }
//        }
    }

}