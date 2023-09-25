// 메뉴에 마우스를 올리면 하위 카테고리를 자동으로 표시
$(document).ready(function () {
    $('.dropdown').hover(
        function () {
            $(this).addClass('show');
            $(this).find('.dropdown-menu').addClass('show');
        },
        function () {
            $(this).removeClass('show');
            $(this).find('.dropdown-menu').removeClass('show');
        }
    );
});
