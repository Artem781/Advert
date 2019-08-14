package by.it.databasetask;//package project.java;
//
//import project.java.bean.Advert;
//import project.java.bean.Role;
//import project.java.bean.Account;
//import project.java.dao.Dao;
//import project.java.dao.InnerJoinById;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class TesterDao {
//    public static void main(String[] args) throws SQLException, IOException {
//        // for (int i = 0; i < 20; i++) {
//        Dao.restoreDB();
//            Dao dao = Dao.getDao();
//            Role role = new Role();
//            Account user = new Account();
//            Advert ad = new Advert();
//
//
//            //манипуляции с role
//            //create
//            role.setRole("moderator");
//            if (dao.role.create(role))
//                System.out.println("\tCreate role successful\n" + role + "\n");
//            //update
//            role.setRole("superuser");
//            if (dao.role.update(role))
//                System.out.println("\tUpdate role successful\n" + role + "\n");
//            //read
//            role = dao.role.read(role.getId());
//            System.out.println("\tRead role successful\n" + role + "\n");
//
//            //манипуляции с таблицей user
//            //create
//            user.setName("Genady");
//            user.setLogin("Gen4ik");
//            user.setPassword("Gen4ik");
//            user.setBirthday("1994.05.24");
//            user.setEmail("gen4ik@mail.ru");
//            user.setTel("+79038652555");
//            user.setRole(2);
//            if (dao.user.create(user))
//                System.out.println("\tCreate user successful\n" + user + "\n");
//            //update
//            user.setEmail("changed!_setEmail done");
//            if (dao.user.update(user))
//                System.out.println("\tUpdate user successful\n" + user + "\n");
//            //read
//            user = dao.user.read(user.getId());
//            System.out.println("\tRead user successful\n" + user + "\n");
//
//
//            //манипуляции с таблицей ads
//            //create
//            ad.setTitle("Лучшее авто за 5000$");
//            ad.setDescription("norm auto");
//            ad.setBrand("BMW");
//            ad.setModel("X5m");
//            ad.setColor("Black");
//            ad.setBody("Hatchback");
//            ad.setYear(2016);
//            ad.setEngine(2.5);
//            ad.setAt("Automatic");
//            ad.setDriveunit("Full");
//            ad.setEquipment("Lux");
//            ad.setMilage(42000);
//            ad.setCrashed("Yes");
//            ad.setPrice(156000.3);
//            ad.setAccountIdFk(user.getId());
//            if (dao.ad.create(ad))
//                System.out.println("\tCreate ad successful\n" + ad + "\n");
//            //update
//            ad.setYear(2014);
//            ad.setPrice(140000);
//            if (dao.ad.update(ad))
//                System.out.println("\tUpdate ad successful\n" + ad + "\n");
//            //read
//            ad = dao.ad.read(ad.getId());
//            System.out.println("\tRead ad successful\n" + ad + "\n");
//            {
//                //delete ad
//                if (dao.ad.delete(ad))
//                    System.out.println("\tDelete ad succefull\n" + ad + "\n");
//                //delete user
//                if (dao.user.delete(user))
//                    System.out.println("\tDelete user successful\n" + user + "\n");
//                //delete role
//                if (dao.role.delete(role))
//                    System.out.println("\tDelete role successful\n" + role + "\n");
//            }
//            InnerJoinById.findAllRows();
//            InnerJoinById.findRolesRows();
//            //Dao.restoreDB();
//            //Tools.sendTg(ad.getBrand(), ad.getModel(), ad.getYear(), ad.getPrice());
//        }
//        //Dao.restoreDB();
//    //}
//}
