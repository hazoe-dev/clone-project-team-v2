<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="grid__column-5">
	<form action="" class="form__book">

		<div class="imformation__form">
			<h2>Thông tin chi tiết sách</h2>


			<div class="form__label-item">
				<div class="form-lable">

					<label for="fname">Tên sách</label> <br> <input type="text"
						id="fname" name="fname" value="" size="50" class="setsize">
				</div>
				<div class="form-lable">
					<label for="fname">Link hình</label><br>
					<!-- <input type="text" id="fname" name="fname" value="" size="41" >  -->
					<input type="file" id="fname" name="fname" value="Browser" size="8"
						class="setsize">

				</div>
				<div class="form-lable">

					<label for="fname">Thể loại</label> <br>
					<!-- <input type="text" id="fname" name="fname" value="" size="12" > -->
					<select name="status" id="status">
						<option value="Choose">Choose...</option>
						<option value="update">Văn học</option>
						<option value="full">Kỹ Năng sống</option>

					</select> <a href="" class="btn-cate">Tâm lý<i
						class="btn-i fas fa-times"></i></a> <a class="btn-cate" href="">Y
						học<i class="btn-i fas fa-times"></i>
					</a>
				</div>
				<div class="form-lable">

					<label for="fname">Giới thiệu sách</label> <br>
					<textarea rows="3" cols="53" class="setsize"></textarea>
				</div>
				<div class="form-lable">

					<label for="fname">Định dạng đọc</label> <br>
					<div class="form-lable-check">
						<input type="checkbox"> <label> Đọc online</label><br>
					</div>
				</div>
				<div class="form-lable-border">

					<label for="fname" class="form-header">Danh sách chương</label>
					<button class="js-open" id="js-open1">+</button>
					<br>
					<!-- <div class="form-lable-bor">
        <div class="select_input">
        <button>
        <span class="select-input__label">Định dạng</span>
        <i class="select-input__icon fas fa-angle-down"></i>
        <ul class="select-input__list">
            <li class="select-input__item">
                
                <a href="" class="select-input__link">Đã đăng</a>
            </li>
            <li class="select-input__item">
                <a href="" class="select-input__link">Đã xóa</a>
                
            </li>
        </ul></button></div>
        <div class="select_input">

        <input type="text" id="fname" name="fname" value="Tên phần"  size="46">
        </div>
        <div class="select_input">

            <input type="text" id="fname" name="fname" value="Tên phần"  size="46">
            </div>
            <div class="select_input-btn">
        <button>Hủy</button>
        <button>Lưu</button>
        
    </div>
    

    </div> -->

					<br> <br>
					<div class="select-index">
						<ol>
							<li>Giới thiệu <!-- <button class="space">Xem chi tiết</button> -->
								<button class="space js-content ">Xem chi tiết</button>
							</li>
							<li>Lời tựa
								<button class="space-1 js-content ">Xem chi tiết</button>
							</li>
							<br>
						</ol>

					</div>

				</div>
				<div class="form-lable">



					<input type="checkbox"> <label> Download</label><br>
					<!-- <input type="text" id="fname" name="fname" value="Link download"  size="41">
    <button >Browser</button> -->
					<input type="file" id="fname" name="fname" value="Browser">
				</div>
				<div class="form-lable-tyle">
					<div class="form-lable-3">
						<label> Ngày đăng</label><br> <input type="date" size="8">
					</div>
					<div class="form-lable-3">
						<label>Ưu tiên hiển thị</label><br> <input type="text"
							size="12">
					</div>
					<div class="form-lable-3">
						<label> Trạng thái</label><br> <select name="status"
							id="status">
							<option value="Choose">Choose...</option>
							<option value="update">UpDate chương</option>
							<option value="full">Full</option>

						</select>
					</div>



				</div>
			</div>

		</div>
	</form>
</div>
<div class="grid__column-5-2">

	<div class="imformation__form-2">


		<div class="form__label-item">
			<div class="form-lable">

				<label for="fname">Tên tác giả</label> <br> <input type="text"
					id="fname" name="fname" value="" size="50" class="setsize">
			</div>
			<div class="form-lable">

				<label for="fname">Thông báo</label> <br> <input type="text"
					id="fname" name="fname" value="" size="50" class="setsize">
			</div>



			<div class="form-lable-des">

				<label for="fname">Mô tả danh sách chương</label> <br>
				<textarea rows="3" cols="53" class="setsize"></textarea>
			</div>
			<div class="form-lable">

				<label for="fname">Định dạng đọc</label> <br>
				<div class="form-lable-check">
					<input type="checkbox"> <label> Nghe Audio</label><br>
				</div>
			</div>
			<div class="form-lable-border">


				<label for="fname" class="form-header">Danh sách phần</label>
				<button id="open" class="js-open1">+</button>
				<br>
				<!-- <div class="form-lable-bor">
        <div class="select_input">
            <button>
            <span class="select-input__label">Định dạng</span>
            <i class="select-input__icon fas fa-angle-down"></i>
            <ul class="select-input__list">
                <li class="select-input__item">
                    
                    <a href="" class="select-input__link">Đã đăng</a>
                </li>
                <li class="select-input__item">
                    <a href="" class="select-input__link">Đã xóa</a>
                    
                </li>
            </ul></button></div>
            <div class="select_input">
    
            <input type="text" id="fname" name="fname" value="Tên phần"  size="46">
            </div>
            <div class="select_input">
    
                <input type="text" id="fname" name="fname" value="Tên phần"  size="46">
                </div>
                <div class="select_input-btn">
            <button>Hủy</button>
            <button>Lưu</button>
            
        </div>
        
    
        </div> -->

				<br>
				<br>
				<div class="select-index">
					<ol>
						<li>Giới thiệu <!-- <button class="space">Xem chi tiết</button> -->
							<button class="space js-content1">Xem chi tiết</button>
						</li>
						<li>Lời tựa
							<button class="space-1 js-content1 ">Xem chi tiết</button>
						</li>
						<br>
					</ol>
				</div>

			</div>


			<div class="form-lable">



				<input type="checkbox"> <label> Đọc PDF</label><br>
				<!-- <input type="text" id="fname" name="fname" value="Link PDF" size="41"> -->
				<input type="file" id="fname" name="fname" value="Browser">
				<!-- <button >Browser</button> -->
			</div>

		</div>

	</div>

	<div class="form__end">

		<input type="button" value="Submit" class="sub"> <a href=""
			v="" class="back">Trở lại</a>
	</div>
</div>