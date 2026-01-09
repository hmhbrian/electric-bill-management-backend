# Hệ thống Quản lý Hóa đơn Điện (Electric Bill Management System)

Dự án này là một ứng dụng backend được xây dựng bằng **Spring Boot** nhằm quản lý thông tin khách hàng, hóa đơn điện, tài khoản điện năng và phản hồi từ người dùng.

## 🚀 Công nghệ sử dụng

Hệ thống được xây dựng dựa trên các công cụ và thư viện hiện đại:

- **Ngôn ngữ:** Java 17
- **Framework:** Spring Boot 3.4.0
- **Quản lý database:** Spring Data JPA
- **Cơ sở dữ liệu:** Oracle Database (OJDBC 11)
- **Công cụ quản lý dự án:** Maven

## ✨ Các tính năng chính

Hệ thống cung cấp các API để quản lý các thực thể sau:

1.  **Quản lý Khách hàng (Customer):** Lưu trữ và quản lý thông tin cá nhân của người sử dụng điện.
2.  **Quản lý Tài khoản Điện (AccountElec):** Quản lý các loại tài khoản điện năng liên kết với khách hàng.
3.  **Quản lý Hóa đơn (Electric Bill):** Theo dõi chỉ số tiêu thụ và tính toán/quản lý hóa đơn tiền điện hàng tháng.
4.  **Phản hồi (Feedback):** Tiếp nhận và xử lý các ý kiến, khiếu nại từ khách hàng.
5.  **Phân loại người dùng (User Type):** Quản lý định mức và các loại đối tượng sử dụng điện khác nhau.

## 📂 Cấu trúc dự án

Dự án tuân theo cấu trúc chuẩn của Spring Boot:

- `src/main/java/com/example/demo/controller`: Chứa các REST Controller xử lý yêu cầu HTTP.
- `src/main/java/com/example/demo/entity`: Định nghĩa các thực thể (Models) tương ứng với bảng trong database.
- `src/main/java/com/example/demo/repository`: Cung cấp các Interface để truy xuất dữ liệu từ database.
- `src/main/java/com/example/demo/Service`: Chứa các tầng logic nghiệp vụ của ứng dụng.
- `src/main/java/com/example/demo/DTO`: Chứa các Data Transfer Objects dùng để trao đổi dữ liệu.

## 🛠️ Hướng dẫn cài đặt và chạy ứng dụng

### 1. Yêu cầu hệ thống

- Java JDK 17
- Maven 3.x
- Một phiên bản Oracle Database đang hoạt động.

### 2. Cấu hình biến môi trường

Tạo một file `.env` tại thư mục gốc của dự án và thêm các thông tin sau (thay thế bằng thông tin thực tế của bạn):

```env
DB_URL=jdbc:oracle:thin:@<HOST>:<PORT>/<SERVICE_NAME>
DB_USERNAME=<YOUR_USERNAME>
DB_PASSWORD=<YOUR_PASSWORD>
```

Ứng dụng sẽ tự động tải các biến này thông qua cấu hình trong `application.properties`.

### 3. Chạy ứng dụng

Dùng Maven để khởi động ứng dụng:

```bash
mvnw spring-boot:run
```

Ứng dụng sẽ mặc định khởi chạy tại cổng `8080`.
