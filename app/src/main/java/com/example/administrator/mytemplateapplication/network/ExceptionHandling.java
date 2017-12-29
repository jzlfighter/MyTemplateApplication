package com.example.administrator.mytemplateapplication.network;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.WindowManager;

import com.example.administrator.mytemplateapplication.network.entity.HttpResult;
import com.example.administrator.mytemplateapplication.tools.utils.ContextHolder;
import com.example.administrator.mytemplateapplication.tools.utils.ToastUtil;


/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/5/30 11:53
 * <p/>
 * Description: 异常处理
 */
@SuppressWarnings("unchecked")
public final class ExceptionHandling {
    public static void operate(final HttpResult result) {
        switch (result.getCode()) {
            case AppResultCode.TOKEN_TIMEOUT:
//                User tokenMo = SharedInfo.getInstance().getEntity(User.class);
//                if (null != tokenMo) {
//                    Call<HttpResult<User>> call = RetrofitClient.create(UserService.class).refreshToken(tokenMo.getRefreshToken());
//                    call.enqueue(new RequestCallBack<HttpResult<User>>() {
//                        @Override
//                        public void onSuccess(Call<HttpResult<User>> call, Response<HttpResult<User>> response) {
//                            SharedInfo.getInstance().saveEntity(response.body().getData());
//                        }
//                    });
//                } else {
//                    UserLogic.signOut();
//                    Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.UserInfoManage_Login, Constant.STATUS_3)), 0);
//                }
                break;

            case AppResultCode.TOKEN_REFRESH_TIMEOUT:
//                UserLogic.signOut();
//                Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.UserInfoManage_Login, Constant.STATUS_3)), 0);
                break;
            case AppResultCode.TOKEN_NOT_UNIQUE:
            case AppResultCode.TOKEN_NOT_EXIT:
//                DialogUtils.showDialog(ActivityManage.peek(), R.string.user_login_reset, R.string.user_login_two, new OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        UserLogic.signOut();
//                        Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.UserInfoManage_Login, Constant.STATUS_3))
//                                , 0);
//                        sweetAlertDialog.dismissWithAnimation();
//                    }
//                }, new OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        UserLogic.signOut();
//                        Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.UserInfoManage_Login, Constant.STATUS_3))
//                                , 0);
//                        sweetAlertDialog.dismissWithAnimation();
//                    }
//                });
                break;

            default:
                break;
        }
        if (result.getCode() == 400400 &&result.getCode()!=800800) {
            String msg = result.getMsg();
            final String url = result.getUrl();
            System.out.println("====="+url);
            AlertDialog.Builder builder = new AlertDialog.Builder(ContextHolder.getContext());
            AlertDialog dialog = builder.setMessage(msg)
                    .setCancelable(false)
                    .setTitle("版本更新")
                    .setPositiveButton("升级", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Uri uri = Uri.parse(url);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            ContextHolder.getContext().startActivity(intent);
                        }
                    }).create();

            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            dialog.setCanceledOnTouchOutside(false);//点击屏幕不消失

            if (!dialog.isShowing()) {//此时提示框未显示
                dialog.show();
            }
        }
        if (result.getCode() != 410 && result.getCode() != 413 && result.getCode() != 412 && result.getCode() != 411 && result.getCode() != 800800 && result.getCode() != 400400) {
            ToastUtil.toast(result.getMsg());
        }
    }

    /**
     * 跳转应用市场
     * @param context
     * @param packageName
     */
    public static void goToMarket(Context context, String packageName) {
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            goToMarket.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
