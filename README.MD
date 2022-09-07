# Thư viện sách (Library)
## Giới thiệu
* Chương trình Đạo cụ khu tà diệt quỷ giúp người dùng quản lý thông tin đạo cụ và tổng sức mạnh khi kết hợp các đạo cụ một cách dễ dàng, giao diện không thân thiện nên dùng java swing để nâng cấp UI.
* Sản phẩm này lấy cảm hứng từ ứng dụng khác cũng là quản lý sản phẩm nhưng nghiệp vụ nó lạ lắm.
* Đây chỉ là một sản phẩm đơn giản mang tính chất hư cấu được viết trong vài ba ngày còn nhiều lỗi nói chung là dùng được.

## Thiết kế dữ liệu
	* controller:
		1. BookManager (Quản lý thông tin tài liệu)
			* add sách mới
			* edit thông tin sách
			* remove sách
			* find và display theo: tên sách/tác giả/năm xuất bản/thể loại
		2. MemberManager (Quản lý người dùng)
			* add member mới
			* edit thông tin member
			* remove member
			* display list member
		3. OrderManager (Quản lý phiếu mượn sách)
			* add phiếu mới
			* edit phiếu
			* remove phiếu
			* find và display theo: tên người đọc, số lượng đầu sách giảm dần
	* model
		* Book: abstract class
			* ProgrammingBook: Class
			* FictionBook: Class
			* NovelBook: Class
		* Member: interface
			* InternalMember: Class
			* ExternalMember: Class
		* Order: Class

	* storage:
		* IGenericReadWriteData<T>
		* book
			* IReadWriteData extends IGenericReadWriteData<Book>
			* ReadWriteFile implements IReadWriteData
			* ReadWriteFileExcel implements IReadWriteData
		* member
			* IReadWriteData extends IGenericReadWriteData<Member>
			* ReadWriteFile implements IReadWriteData
			* ReadWriteFileExcel implements IReadWriteData
		* order
			* IReadWriteData extends IGenericReadWriteData<Order>
			* ReadWriteFile implements IReadWriteData
			* ReadWriteFileExcel implements IReadWriteData
	* views

## Các chức năng của thư viện:
	* Thủ thư:
		1. Thêm sách vào thư viện
		2. In ra list book
		3. Thêm người dùng vào thư viện
		4. In ra list member
		5. Thêm vào phiếu mượn sách
		6. In ra list order
		7. Sắp xếp danh sách trên theo: tên người đọc, số lượng đầu sách giảm dần
		8. Tìm kiếm và hiển thị Order theo tên người đọc
	* Người mượn:
		1. Login
		2. Sửa thông tin cá nhân member
		3. Hiển thị các đầu sách đang mượn

