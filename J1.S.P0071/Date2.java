String getDate(String msg) {
        String input;
        Date date;
        String resultDate;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } // \d{1,2}: the number have 1 or 2 digit number
            //[-]: contain character -
            //\d{4}: the number must have 4 digit
            else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Input is wrong format");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                Date now = new Date();
                //check date must be before now
                if (date.before(now)) {
                    System.out.println("Date could not be the past. Please enter again!");
                    continue;
                }
                break;
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
            }
        } while (true);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        resultDate = dateFormat.format(date);
        return resultDate;
    }
