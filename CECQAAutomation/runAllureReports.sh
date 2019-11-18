#!/bin/bash

DTS=$(date +%Y%m%d-%H%M%S)

#delete allure-results before generating new report
#rm allure-results/*
#generate allure results
allure-2.7.0/bin/allure generate -o AllureReports/AllureReports_${DTS}

wait

#move all files from the output folder to an archive folder
#mkdir AllureOutputArchive/Output_${DTS}
#mv  -v Output/* OutputArchive_${DTS}
mv  -v AllureReports/* AllureOutputArchive/Output_${DTS}

echo $PWD
