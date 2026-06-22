Dựa trên log Selenium bạn cung cấp, có thể viết phần **Báo cáo kiểm thử chức năng bằng Selenium WebDriver** như sau:

# BÁO CÁO KIỂM THỬ TỰ ĐỘNG WEBSITE FAHASA BẰNG SELENIUM

## 1. Mục tiêu kiểm thử

Thực hiện kiểm thử tự động các chức năng cơ bản của website Fahasa bằng Selenium WebDriver nhằm đánh giá:

* Đăng nhập hệ thống.
* Tìm kiếm sản phẩm.
* Thao tác với giỏ hàng.
* Quy trình thanh toán.

---

## 2. Môi trường kiểm thử

| Thành phần         | Giá trị            |
| ------------------ | ------------------ |
| Công cụ kiểm thử   | Selenium WebDriver |
| Ngôn ngữ           | Java               |
| Trình duyệt        | Google Chrome      |
| Website kiểm thử   | Fahasa             |
| Hình thức kiểm thử | Black Box Testing  |
| Loại kiểm thử      | Functional Testing |

---

## 3. Kịch bản kiểm thử

### Test Case 1: Đăng nhập

**Mục tiêu**

Kiểm tra khả năng đăng nhập vào hệ thống Fahasa.

**Kết quả**

```text
LOGIN SUCCESS
```

**Đánh giá**

PASS

---

### Test Case 2: Tìm kiếm sản phẩm

**Mục tiêu**

Tìm kiếm sách "Đắc Nhân Tâm".

**URL kết quả**

```text
https://www.fahasa.com/searchengine?q=Đắc nhân tâm
```

**Kết quả**

```text
SEARCH TEST PASSED
```

**Đánh giá**

PASS

---

### Test Case 3: Thêm sản phẩm vào giỏ hàng

**Các bước thực hiện**

1. Mở sản phẩm đầu tiên.
2. Thêm sản phẩm vào giỏ hàng.

**Kết quả**

```text
Đã click sản phẩm đầu tiên
Đã thêm vào giỏ hàng
```

**Đánh giá**

PASS

---

### Test Case 4: Tăng số lượng sản phẩm

**Mục tiêu**

Tăng số lượng sản phẩm trong giỏ hàng.

**Kết quả**

```text
Số lượng trước khi tăng: 1
Số lượng sau khi tăng: 1
Không thể tăng số lượng sản phẩm
THÔNG BÁO: Số lượng hàng trong kho không đủ
```

**Nguyên nhân**

Website trả về thông báo:

```text
Số lượng hàng trong kho không đủ
```

Do đó hệ thống không cho phép tăng thêm số lượng.

**Đánh giá**

FAIL

---

### Test Case 5: Giảm số lượng sản phẩm

**Mục tiêu**

Giảm số lượng sản phẩm trong giỏ hàng.

**Kết quả**

```text
Số lượng trước khi giảm: 1
Số lượng sau khi giảm: 1
Giảm số lượng thất bại
```

**Nguyên nhân**

Sản phẩm chỉ còn số lượng bằng 1 nên website không cho phép giảm tiếp.

**Đánh giá**

FAIL

---

### Test Case 6: Xóa sản phẩm khỏi giỏ hàng

**Kết quả**

```text
Đã click xóa sản phẩm
```

**Đánh giá**

PASS

---

### Tổng kết Cart Test

| Chức năng         | Kết quả |
| ----------------- | ------- |
| Mở sản phẩm       | PASS    |
| Thêm vào giỏ hàng | PASS    |
| Tăng số lượng     | FAIL    |
| Giảm số lượng     | FAIL    |
| Xóa sản phẩm      | PASS    |

**Kết luận Cart Test**

```text
CART TEST FAILED
```

Nguyên nhân chính là giới hạn số lượng tồn kho của sản phẩm.

---

## 4. Kiểm thử thanh toán

### Test Case 7: Chọn sản phẩm thanh toán

**Kết quả**

```text
Không tìm thấy checkbox sản phẩm
```

**Đánh giá**

FAIL

---

### Test Case 8: Mở trang thanh toán

**Kết quả**

```text
Mở trang thanh toán: false
```

**Đánh giá**

FAIL

---

### Tổng kết Payment Test

| Chức năng           | Kết quả |
| ------------------- | ------- |
| Tick chọn sản phẩm  | FAIL    |
| Mở trang thanh toán | FAIL    |

**Kết luận**

```text
PAYMENT TEST FAILED
```

Nguyên nhân có thể:

* Sản phẩm đã bị xóa khỏi giỏ hàng trước khi thực hiện thanh toán.
* Selenium không tìm thấy phần tử checkbox do thay đổi giao diện hoặc locator sai.
* Website tải chậm làm phần tử chưa xuất hiện khi script thực thi.

---

## 5. Kết quả tổng hợp

| STT | Chức năng                | Kết quả |
| --- | ------------------------ | ------- |
| 1   | Đăng nhập                | PASS    |
| 2   | Tìm kiếm sản phẩm        | PASS    |
| 3   | Mở sản phẩm              | PASS    |
| 4   | Thêm vào giỏ hàng        | PASS    |
| 5   | Tăng số lượng            | FAIL    |
| 6   | Giảm số lượng            | FAIL    |
| 7   | Xóa sản phẩm             | PASS    |
| 8   | Tick sản phẩm thanh toán | FAIL    |
| 9   | Mở trang thanh toán      | FAIL    |

---

## 6. Thống kê

| Tổng số Test Case | PASS | FAIL | Tỷ lệ PASS |
| ----------------- | ---- | ---- | ---------- |
| 9                 | 5    | 4    | 55.56%     |

---

## 7. Kết luận

Quá trình kiểm thử tự động bằng Selenium cho thấy các chức năng cơ bản như **đăng nhập, tìm kiếm sản phẩm, mở chi tiết sản phẩm và thêm sản phẩm vào giỏ hàng hoạt động đúng**. Tuy nhiên, các chức năng liên quan đến **quản lý số lượng sản phẩm trong giỏ hàng và thanh toán chưa đạt yêu cầu**.

Các lỗi ghi nhận chủ yếu xuất phát từ:

* Giới hạn tồn kho sản phẩm.
* Không tìm thấy phần tử giao diện phục vụ thanh toán.
* Kịch bản kiểm thử chưa xử lý đầy đủ các trường hợp ngoại lệ của website.

Do đó cần điều chỉnh lại script Selenium, cập nhật locator và lựa chọn sản phẩm còn đủ hàng để thực hiện kiểm thử thanh toán hoàn chỉnh.
