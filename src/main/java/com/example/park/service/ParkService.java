package com.example.park.service;

import com.example.park.commonbox.ResultGenerator;
import com.example.park.mapper.CarMapper;
import com.example.park.mapper.ParkMapper;
import com.example.park.pojo.dto.ParkEndDTO;
import com.example.park.pojo.dto.ParkPO;
import com.example.park.pojo.dto.ParkStartDTO;
import com.example.park.pojo.po.CarPO;
import com.example.park.pojo.vo.ParkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:38 PM
 * @since JDK 1.8
 */
@Service
public class ParkService {
    @Autowired
    private ParkMapper parkMapper;
    @Autowired
    private CarPlaceService carPlaceService;
    @Autowired
    private CarMapper carMapper;

    public ParkVO endPark() {
        return null;
    }

    public boolean start(ParkStartDTO parkStartDTO) {
        //更新车位状态为1
        carPlaceService.updateStatus(parkStartDTO.getCarPlaceId(), 1);
        return parkMapper.start(parkStartDTO);
    }

    public ParkPO findById(Integer id) {
        return parkMapper.findById(id);
    }

    public boolean end(Integer id) {
        Boolean flag = true;
        ParkPO po = parkMapper.findById(id);
        if (po.getParkFee() != 0) {
            return true;
        }
        //更新车位状态为0
        carPlaceService.updateStatus(po.getCarPlaceId(), 0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = po.getParkStartTime();
            endDate = new Date(System.currentTimeMillis());
            //todo 修改异常处理的方式
        } catch (Exception e) {
            e.printStackTrace();
        }
        //todo 领域驱动设计
        ParkVO parkVO = getVO(startDate, endDate, po.getCarId());
        //更新费用跟时间
        flag = flag & parkMapper.updateFeeAndEndTime(id, parkVO.getParkFee(), endDate);
        //更新车辆代金券、总时间、代金券累加时间。
        flag = flag & carMapper.updateTimeAndAward(parkVO.getCarAwardNumber(), parkVO.getCarTime(), parkVO.getCarAwardTime(), po.getCarId());
        return flag;
    }

    public ParkVO getVO(Date start, Date end, Integer carId) {
        ParkVO parkVO = new ParkVO();
        CarPO carPO = carMapper.findCarById(carId);
        Integer djq = carPO.getCarAwardNumber();
        Integer time = carPO.getCarTime();
        Integer awardTime = carPO.getCarAwardTime();
        Double fee = 0.0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date timeMorning = null;
        Date sixAM = null;
        Date tomorowSevenPM = null;
        Integer sum = 0;
        Integer dis = 0;
        try {
            start = formatter.parse(formatter.format(start));
            end = formatter.parse(formatter.format(end));

            timeMorning = format.parse(addDateMinut(start, 0));
            sixAM = formatter.parse(addDateMinut(timeMorning, 18));
            tomorowSevenPM = formatter.parse(addDateMinut(sixAM, 13));
            while (getHourDistance(start, end, formatter) > 24) {
                end = formatter.parse(addDateMinut(end, -24));
                sum = sum + 1;
            }
            if (getHourDistance(start, sixAM, formatter) >= 0 && getHourDistance(tomorowSevenPM, end, formatter) >= 0) {
                dis = Math.abs((getHourDistance(start, end, formatter) - 13) * 2);
                fee = dis + 5.0 + sum * 27;
            } else {
                dis = Math.abs(getHourDistance(start, end, formatter) * 2);
                fee = dis + sum * 27 + 0.0;
            }
            System.out.println(fee);
            int d = 0;
            for (int i = 1; i <= djq; i++) {
                if (fee - 2 * i <= 0) {
                    d = i - 1;
                    break;
                } else {
                    d = i;
                }
            }
            fee = fee - 2 * d;
            parkVO.setCarAwardNumber(djq - d);
            parkVO.setParkFee(fee);
            Integer hour = getHourDistance(start, end, formatter);
            awardTime = hour + awardTime + sum * 24;
            while (awardTime >= 300) {
                awardTime = awardTime - 300;
                parkVO.setCarAwardNumber(parkVO.getCarAwardNumber() + 1);
            }
            parkVO.setCarAwardTime(awardTime);
            parkVO.setCarTime(time + hour + sum * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parkVO;
    }

    //时间差 时间差》0
    public static Integer getHourDistance(Date s, Date e, SimpleDateFormat formatter) {
        long from = s.getTime();
        long to = e.getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes % 60 == 0) {
            int x = minutes / 60;
            return x;
        } else {
            int y = minutes / 60;
            if (minutes > 0) {
                y = y + 1;
            }
            return y;
        }
    }

    public static String addDateMinut(Date date, int hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (date == null)
            return "";
//        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
//        System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return format.format(date);
    }

    public List<ParkPO> findAll(Integer page) {
        Integer start = (page - 1) * 10;
        return parkMapper.findAll(start);
    }

    public List<ParkPO> findByCarNumber(String carNumber, Integer page) {
        Integer start = (page - 1) * 10;
        return parkMapper.findByCarNumber(carNumber, start);
    }

    public List<ParkPO> findByMasterId(Integer userId, Integer page) {
        Integer start = (page - 1) * 10;
        return parkMapper.findByMasterId(userId, start);
    }
}
