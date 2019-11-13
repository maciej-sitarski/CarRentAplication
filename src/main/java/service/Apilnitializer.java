package service;

import dao.BrandDaoBean;
import dao.CarDaoBean;
import dao.ClientTypeDaoBean;
import dao.DepartmentDaoBean;
import dao.ModelDaoBean;
import dao.PositionDaoBean;
import dao.SectionDaoBean;
import dao.WorkerDaoBean;
import entity.Brand;
import entity.Car;
import entity.ClientType;
import entity.Department;
import entity.Model;
import entity.Position;
import entity.Section;
import entity.Worker;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.apache.commons.codec.digest.DigestUtils;

@Singleton
@Startup
public class Apilnitializer {

  @Inject
  DepartmentDaoBean departmentDaoBean;

  @Inject
  CarDaoBean carDaoBean;

  @Inject
  SectionDaoBean sectionDaoBean;

  @Inject
  BrandDaoBean brandDaoBean;

  @Inject
  ModelDaoBean modelDaoBean;

  @Inject
  PositionDaoBean positionDaoBean;

  @Inject
  WorkerDaoBean workerDaoBean;

  @Inject
  ClientTypeDaoBean clientTypeDaoBean;

  @PostConstruct
  protected void init() {

    Department departmentKrakow = new Department();
    departmentKrakow.setCity("Kraków");

    Department departmentWarszawa = new Department();
    departmentWarszawa.setCity("Warszawa");

    Department departmentGdansk = new Department();
    departmentGdansk.setCity("Gdańsk");

    Department departmentPoznan = new Department();
    departmentPoznan.setCity("Poznań");

    Department departmentWroclaw = new Department();
    departmentWroclaw.setCity("Wrocław");

    Department departmentLodz = new Department();
    departmentLodz.setCity("Łódź");

    Department departmentLublin = new Department();
    departmentLublin.setCity("Lublin");

    Department departmentSzczecin = new Department();
    departmentSzczecin.setCity("Szczecin");

    departmentDaoBean.saveDepartment(departmentKrakow);
    departmentDaoBean.saveDepartment(departmentWarszawa);
    departmentDaoBean.saveDepartment(departmentGdansk);
    departmentDaoBean.saveDepartment(departmentPoznan);
    departmentDaoBean.saveDepartment(departmentWroclaw);
    departmentDaoBean.saveDepartment(departmentLodz);
    departmentDaoBean.saveDepartment(departmentLublin);
    departmentDaoBean.saveDepartment(departmentSzczecin);

    Section sectionA = new Section();
    sectionA.setName("a");
    sectionA.setPrice(70L);

    Section sectionB = new Section();
    sectionB.setName("b");
    sectionB.setPrice(80L);

    Section sectionC = new Section();
    sectionC.setName("c");
    sectionC.setPrice(100L);

    Section sectionD = new Section();
    sectionD.setName("d");
    sectionD.setPrice(150L);

    Section sectionSuv = new Section();
    sectionSuv.setName("suv");
    sectionSuv.setPrice(199L);

    Section section7os = new Section();
    section7os.setName("7os");
    section7os.setPrice(199L);

    Section sectionBus = new Section();
    sectionBus.setName("bus");
    sectionBus.setPrice(250L);

    Section sectionPremium = new Section();
    sectionPremium.setName("premium");
    sectionPremium.setPrice(300L);

    sectionDaoBean.saveSection(sectionA);
    sectionDaoBean.saveSection(sectionB);
    sectionDaoBean.saveSection(sectionC);
    sectionDaoBean.saveSection(sectionD);
    sectionDaoBean.saveSection(sectionSuv);
    sectionDaoBean.saveSection(section7os);
    sectionDaoBean.saveSection(sectionBus);
    sectionDaoBean.saveSection(sectionPremium);

    Brand brandOpel = new Brand();
    brandOpel.setName("Opel");

    Brand brandSeat = new Brand();
    brandSeat.setName("Seat");

    Brand brandToyota = new Brand();
    brandToyota.setName("Toyota");

    Brand brandRenault = new Brand();
    brandRenault.setName("Renault");

    Brand brandHyundai = new Brand();
    brandHyundai.setName("Hyundai");

    Brand brandBmw = new Brand();
    brandBmw.setName("BMW");

    Brand brandFord = new Brand();
    brandFord.setName("Ford");

    Brand brandNissan = new Brand();
    brandNissan.setName("Nissan");

    Brand brandVolvo = new Brand();
    brandVolvo.setName("Volvo");

    Brand brandAudi = new Brand();
    brandAudi.setName("Audi");

    brandDaoBean.saveBrand(brandOpel);
    brandDaoBean.saveBrand(brandSeat);
    brandDaoBean.saveBrand(brandToyota);
    brandDaoBean.saveBrand(brandRenault);
    brandDaoBean.saveBrand(brandHyundai);
    brandDaoBean.saveBrand(brandBmw);
    brandDaoBean.saveBrand(brandFord);
    brandDaoBean.saveBrand(brandNissan);
    brandDaoBean.saveBrand(brandVolvo);
    brandDaoBean.saveBrand(brandAudi);

    Model modelCorsa = new Model();
    modelCorsa.setName("Corsa");
    modelCorsa.setSection(sectionB);

    modelDaoBean.saveModel(modelCorsa);

    Car car1 = new Car();
    car1.setBrand(brandOpel);
    car1.setModel(modelCorsa);
    car1.setDepartment(departmentGdansk);

    Car car2 = new Car();
    car2.setBrand(brandOpel);
    car2.setModel(modelCorsa);
    car2.setDepartment(departmentKrakow);

    Car car3 = new Car();
    car3.setBrand(brandOpel);
    car3.setModel(modelCorsa);
    car3.setDepartment(departmentLodz);

    Car car4 = new Car();
    car4.setBrand(brandOpel);
    car4.setModel(modelCorsa);
    car4.setDepartment(departmentLublin);

    Car car5 = new Car();
    car5.setBrand(brandOpel);
    car5.setModel(modelCorsa);
    car5.setDepartment(departmentPoznan);

    Car car6 = new Car();
    car6.setBrand(brandOpel);
    car6.setModel(modelCorsa);
    car6.setDepartment(departmentSzczecin);

    Model modelClio = new Model();
    modelClio.setName("Clio");
    modelClio.setSection(sectionB);

    modelDaoBean.saveModel(modelClio);

    Car car7 = new Car();
    car7.setBrand(brandRenault);
    car7.setModel(modelClio);
    car7.setDepartment(departmentGdansk);

    Car car8 = new Car();
    car8.setBrand(brandRenault);
    car8.setModel(modelClio);
    car8.setDepartment(departmentKrakow);

    Car car9 = new Car();
    car9.setBrand(brandRenault);
    car9.setModel(modelClio);
    car9.setDepartment(departmentLodz);

    Car car10 = new Car();
    car10.setBrand(brandRenault);
    car10.setModel(modelClio);
    car10.setDepartment(departmentLublin);

    Car car11 = new Car();
    car11.setBrand(brandRenault);
    car11.setModel(modelClio);
    car11.setDepartment(departmentPoznan);

    Car car12 = new Car();
    car12.setBrand(brandRenault);
    car12.setModel(modelClio);
    car12.setDepartment(departmentSzczecin);

    Model modelI20 = new Model();
    modelI20.setName("i20");
    modelI20.setSection(sectionB);

    modelDaoBean.saveModel(modelI20);

    Car car13 = new Car();
    car13.setBrand(brandHyundai);
    car13.setModel(modelI20);
    car13.setDepartment(departmentGdansk);

    Car car14 = new Car();
    car14.setBrand(brandHyundai);
    car14.setModel(modelI20);
    car14.setDepartment(departmentKrakow);

    Car car15 = new Car();
    car15.setBrand(brandHyundai);
    car15.setModel(modelI20);
    car15.setDepartment(departmentLodz);

    Car car16 = new Car();
    car16.setBrand(brandHyundai);
    car16.setModel(modelI20);
    car16.setDepartment(departmentLublin);

    Car car17 = new Car();
    car17.setBrand(brandHyundai);
    car17.setModel(modelI20);
    car17.setDepartment(departmentPoznan);

    Car car18 = new Car();
    car18.setBrand(brandHyundai);
    car18.setModel(modelI20);
    car18.setDepartment(departmentSzczecin);

    Model modelFiesta = new Model();
    modelFiesta.setName("Fiesta");
    modelFiesta.setSection(sectionB);

    modelDaoBean.saveModel(modelFiesta);

    Car car19 = new Car();
    car19.setBrand(brandFord);
    car19.setModel(modelFiesta);
    car19.setDepartment(departmentGdansk);

    Car car20 = new Car();
    car20.setBrand(brandFord);
    car20.setModel(modelFiesta);
    car20.setDepartment(departmentKrakow);

    Car car21 = new Car();
    car21.setBrand(brandFord);
    car21.setModel(modelFiesta);
    car21.setDepartment(departmentLodz);

    Car car22 = new Car();
    car22.setBrand(brandFord);
    car22.setModel(modelFiesta);
    car22.setDepartment(departmentLublin);

    Car car23 = new Car();
    car23.setBrand(brandFord);
    car23.setModel(modelFiesta);
    car23.setDepartment(departmentPoznan);

    Car car24 = new Car();
    car24.setBrand(brandFord);
    car24.setModel(modelFiesta);
    car24.setDepartment(departmentSzczecin);

    Model modelAstra = new Model();
    modelAstra.setName("Astra");
    modelAstra.setSection(sectionC);

    modelDaoBean.saveModel(modelAstra);

    Car car25 = new Car();
    car25.setBrand(brandOpel);
    car25.setModel(modelAstra);
    car25.setDepartment(departmentGdansk);

    Car car26 = new Car();
    car26.setBrand(brandOpel);
    car26.setModel(modelAstra);
    car26.setDepartment(departmentKrakow);

    Car car27 = new Car();
    car27.setBrand(brandOpel);
    car27.setModel(modelAstra);
    car27.setDepartment(departmentLodz);

    Car car28 = new Car();
    car28.setBrand(brandOpel);
    car28.setModel(modelAstra);
    car28.setDepartment(departmentLublin);

    Car car29 = new Car();
    car29.setBrand(brandOpel);
    car29.setModel(modelAstra);
    car29.setDepartment(departmentPoznan);

    Car car30 = new Car();
    car30.setBrand(brandOpel);
    car30.setModel(modelAstra);
    car30.setDepartment(departmentSzczecin);

    Model modelLeon = new Model();
    modelLeon.setName("Leon");
    modelLeon.setSection(sectionC);

    modelDaoBean.saveModel(modelLeon);

    Car car31 = new Car();
    car31.setBrand(brandSeat);
    car31.setModel(modelLeon);
    car31.setDepartment(departmentGdansk);

    Car car32 = new Car();
    car32.setBrand(brandSeat);
    car32.setModel(modelLeon);
    car32.setDepartment(departmentKrakow);

    Car car33 = new Car();
    car33.setBrand(brandSeat);
    car33.setModel(modelLeon);
    car33.setDepartment(departmentLodz);

    Car car34 = new Car();
    car34.setBrand(brandSeat);
    car34.setModel(modelLeon);
    car34.setDepartment(departmentLublin);

    Car car35 = new Car();
    car35.setBrand(brandSeat);
    car35.setModel(modelLeon);
    car35.setDepartment(departmentPoznan);

    Car car36 = new Car();
    car36.setBrand(brandSeat);
    car36.setModel(modelLeon);
    car36.setDepartment(departmentSzczecin);

    Model modelI30 = new Model();
    modelI30.setName("i30");
    modelI30.setSection(sectionC);

    modelDaoBean.saveModel(modelI30);

    Car car37 = new Car();
    car37.setBrand(brandHyundai);
    car37.setModel(modelI30);
    car37.setDepartment(departmentGdansk);

    Car car38 = new Car();
    car38.setBrand(brandHyundai);
    car38.setModel(modelI30);
    car38.setDepartment(departmentKrakow);

    Car car39 = new Car();
    car39.setBrand(brandHyundai);
    car39.setModel(modelI30);
    car39.setDepartment(departmentLodz);

    Car car40 = new Car();
    car40.setBrand(brandHyundai);
    car40.setModel(modelI30);
    car40.setDepartment(departmentLublin);

    Car car41 = new Car();
    car41.setBrand(brandHyundai);
    car41.setModel(modelI30);
    car41.setDepartment(departmentPoznan);

    Car car42 = new Car();
    car42.setBrand(brandHyundai);
    car42.setModel(modelI30);
    car42.setDepartment(departmentSzczecin);

    Model modelMegane = new Model();
    modelMegane.setName("Megane");
    modelMegane.setSection(sectionC);

    modelDaoBean.saveModel(modelMegane);

    Car car43 = new Car();
    car43.setBrand(brandRenault);
    car43.setModel(modelMegane);
    car43.setDepartment(departmentGdansk);

    Car car44 = new Car();
    car44.setBrand(brandRenault);
    car44.setModel(modelMegane);
    car44.setDepartment(departmentKrakow);

    Car car45 = new Car();
    car45.setBrand(brandRenault);
    car45.setModel(modelMegane);
    car45.setDepartment(departmentLodz);

    Car car46 = new Car();
    car46.setBrand(brandRenault);
    car46.setModel(modelMegane);
    car46.setDepartment(departmentLublin);

    Car car47 = new Car();
    car47.setBrand(brandRenault);
    car47.setModel(modelMegane);
    car47.setDepartment(departmentPoznan);

    Car car48 = new Car();
    car48.setBrand(brandRenault);
    car48.setModel(modelMegane);
    car48.setDepartment(departmentSzczecin);

    Model modelCorolla = new Model();
    modelCorolla.setName("Corolla");
    modelCorolla.setSection(sectionC);

    modelDaoBean.saveModel(modelCorolla);

    Car car49 = new Car();
    car49.setBrand(brandToyota);
    car49.setModel(modelCorolla);
    car49.setDepartment(departmentGdansk);

    Car car50 = new Car();
    car50.setBrand(brandToyota);
    car50.setModel(modelCorolla);
    car50.setDepartment(departmentKrakow);

    Car car51 = new Car();
    car51.setBrand(brandToyota);
    car51.setModel(modelCorolla);
    car51.setDepartment(departmentLodz);

    Car car52 = new Car();
    car52.setBrand(brandToyota);
    car52.setModel(modelCorolla);
    car52.setDepartment(departmentLublin);

    Car car53 = new Car();
    car53.setBrand(brandToyota);
    car53.setModel(modelCorolla);
    car53.setDepartment(departmentPoznan);

    Car car54 = new Car();
    car54.setBrand(brandToyota);
    car54.setModel(modelCorolla);
    car54.setDepartment(departmentSzczecin);

    Model modelMondeo = new Model();
    modelMondeo.setName("Mondeo");
    modelMondeo.setSection(sectionD);

    modelDaoBean.saveModel(modelMondeo);

    Car car55 = new Car();
    car55.setBrand(brandFord);
    car55.setModel(modelMondeo);
    car55.setDepartment(departmentGdansk);

    Car car56 = new Car();
    car56.setBrand(brandFord);
    car56.setModel(modelMondeo);
    car56.setDepartment(departmentKrakow);

    Car car57 = new Car();
    car57.setBrand(brandFord);
    car57.setModel(modelMondeo);
    car57.setDepartment(departmentLodz);

    Car car58 = new Car();
    car58.setBrand(brandFord);
    car58.setModel(modelMondeo);
    car58.setDepartment(departmentLublin);

    Car car59 = new Car();
    car59.setBrand(brandFord);
    car59.setModel(modelMondeo);
    car59.setDepartment(departmentPoznan);

    Car car60 = new Car();
    car60.setBrand(brandFord);
    car60.setModel(modelMondeo);
    car60.setDepartment(departmentSzczecin);

    Model modelI40 = new Model();
    modelI40.setName("i40");
    modelI40.setSection(sectionD);

    modelDaoBean.saveModel(modelI40);

    Car car61 = new Car();
    car61.setBrand(brandHyundai);
    car61.setModel(modelI40);
    car61.setDepartment(departmentGdansk);

    Car car62 = new Car();
    car62.setBrand(brandHyundai);
    car62.setModel(modelI40);
    car62.setDepartment(departmentKrakow);

    Car car63 = new Car();
    car63.setBrand(brandHyundai);
    car63.setModel(modelI40);
    car63.setDepartment(departmentLodz);

    Car car64 = new Car();
    car64.setBrand(brandHyundai);
    car64.setModel(modelI40);
    car64.setDepartment(departmentLublin);

    Car car65 = new Car();
    car65.setBrand(brandHyundai);
    car65.setModel(modelI40);
    car65.setDepartment(departmentPoznan);

    Car car66 = new Car();
    car66.setBrand(brandHyundai);
    car66.setModel(modelI40);
    car66.setDepartment(departmentSzczecin);

    Model modelInsignia = new Model();
    modelInsignia.setName("Insignia");
    modelInsignia.setSection(sectionD);

    modelDaoBean.saveModel(modelInsignia);

    Car car67 = new Car();
    car67.setBrand(brandOpel);
    car67.setModel(modelInsignia);
    car67.setDepartment(departmentGdansk);

    Car car68 = new Car();
    car68.setBrand(brandOpel);
    car68.setModel(modelInsignia);
    car68.setDepartment(departmentKrakow);

    Car car69 = new Car();
    car69.setBrand(brandOpel);
    car69.setModel(modelInsignia);
    car69.setDepartment(departmentLodz);

    Car car70 = new Car();
    car70.setBrand(brandOpel);
    car70.setModel(modelInsignia);
    car70.setDepartment(departmentLublin);

    Car car71 = new Car();
    car71.setBrand(brandOpel);
    car71.setModel(modelInsignia);
    car71.setDepartment(departmentPoznan);

    Car car72 = new Car();
    car72.setBrand(brandOpel);
    car72.setModel(modelInsignia);
    car72.setDepartment(departmentSzczecin);

    Model modelTalisman = new Model();
    modelTalisman.setName("Talisman");
    modelTalisman.setSection(sectionD);

    modelDaoBean.saveModel(modelTalisman);

    Car car73 = new Car();
    car73.setBrand(brandRenault);
    car73.setModel(modelTalisman);
    car73.setDepartment(departmentGdansk);

    Car car74 = new Car();
    car74.setBrand(brandRenault);
    car74.setModel(modelTalisman);
    car74.setDepartment(departmentKrakow);

    Car car75 = new Car();
    car75.setBrand(brandRenault);
    car75.setModel(modelTalisman);
    car75.setDepartment(departmentLodz);

    Car car76 = new Car();
    car76.setBrand(brandRenault);
    car76.setModel(modelTalisman);
    car76.setDepartment(departmentLublin);

    Car car77 = new Car();
    car77.setBrand(brandRenault);
    car77.setModel(modelTalisman);
    car77.setDepartment(departmentPoznan);

    Car car78 = new Car();
    car78.setBrand(brandRenault);
    car78.setModel(modelTalisman);
    car78.setDepartment(departmentSzczecin);

    Model modelAvensis = new Model();
    modelAvensis.setName("Avensis");
    modelAvensis.setSection(sectionD);

    modelDaoBean.saveModel(modelAvensis);

    Car car79 = new Car();
    car79.setBrand(brandToyota);
    car79.setModel(modelCorolla);
    car79.setDepartment(departmentGdansk);

    Car car80 = new Car();
    car80.setBrand(brandToyota);
    car80.setModel(modelCorolla);
    car80.setDepartment(departmentKrakow);

    Car car81 = new Car();
    car81.setBrand(brandToyota);
    car81.setModel(modelCorolla);
    car81.setDepartment(departmentLodz);

    Car car82 = new Car();
    car82.setBrand(brandToyota);
    car82.setModel(modelCorolla);
    car82.setDepartment(departmentLublin);

    Car car83 = new Car();
    car83.setBrand(brandToyota);
    car83.setModel(modelCorolla);
    car83.setDepartment(departmentPoznan);

    Car car84 = new Car();
    car84.setBrand(brandToyota);
    car84.setModel(modelCorolla);
    car84.setDepartment(departmentSzczecin);

    Model modelTucson = new Model();
    modelTucson.setName("Tucson");
    modelTucson.setSection(sectionSuv);

    modelDaoBean.saveModel(modelTucson);

    Car car85 = new Car();
    car85.setBrand(brandHyundai);
    car85.setModel(modelTucson);
    car85.setDepartment(departmentGdansk);

    Car car86 = new Car();
    car86.setBrand(brandHyundai);
    car86.setModel(modelTucson);
    car86.setDepartment(departmentKrakow);

    Car car87 = new Car();
    car87.setBrand(brandHyundai);
    car87.setModel(modelTucson);
    car87.setDepartment(departmentLodz);

    Car car88 = new Car();
    car88.setBrand(brandHyundai);
    car88.setModel(modelTucson);
    car88.setDepartment(departmentLublin);

    Car car89 = new Car();
    car89.setBrand(brandHyundai);
    car89.setModel(modelTucson);
    car89.setDepartment(departmentPoznan);

    Car car90 = new Car();
    car90.setBrand(brandHyundai);
    car90.setModel(modelTucson);
    car90.setDepartment(departmentSzczecin);

    Model modelQashqai = new Model();
    modelQashqai.setName("Qashqai");
    modelQashqai.setSection(sectionSuv);

    modelDaoBean.saveModel(modelQashqai);

    Car car91 = new Car();
    car91.setBrand(brandNissan);
    car91.setModel(modelQashqai);
    car91.setDepartment(departmentGdansk);

    Car car92 = new Car();
    car92.setBrand(brandNissan);
    car92.setModel(modelQashqai);
    car92.setDepartment(departmentKrakow);

    Car car93 = new Car();
    car93.setBrand(brandNissan);
    car93.setModel(modelQashqai);
    car93.setDepartment(departmentLodz);

    Car car94 = new Car();
    car94.setBrand(brandNissan);
    car94.setModel(modelQashqai);
    car94.setDepartment(departmentLublin);

    Car car95 = new Car();
    car95.setBrand(brandNissan);
    car95.setModel(modelQashqai);
    car95.setDepartment(departmentPoznan);

    Car car96 = new Car();
    car96.setBrand(brandNissan);
    car96.setModel(modelQashqai);
    car96.setDepartment(departmentSzczecin);

    Model model5 = new Model();
    model5.setName("5");
    model5.setSection(sectionPremium);

    modelDaoBean.saveModel(model5);

    Car car97 = new Car();
    car97.setBrand(brandBmw);
    car97.setModel(model5);
    car97.setDepartment(departmentGdansk);

    Car car98 = new Car();
    car98.setBrand(brandBmw);
    car98.setModel(model5);
    car98.setDepartment(departmentKrakow);

    Car car99 = new Car();
    car99.setBrand(brandBmw);
    car99.setModel(model5);
    car99.setDepartment(departmentLodz);

    Car car100 = new Car();
    car100.setBrand(brandBmw);
    car100.setModel(model5);
    car100.setDepartment(departmentLublin);

    Car car101 = new Car();
    car101.setBrand(brandBmw);
    car101.setModel(model5);
    car101.setDepartment(departmentPoznan);

    Car car102 = new Car();
    car102.setBrand(brandBmw);
    car102.setModel(model5);
    car102.setDepartment(departmentSzczecin);

    Model modelA6 = new Model();
    modelA6.setName("A6");
    modelA6.setSection(sectionPremium);

    modelDaoBean.saveModel(modelA6);

    Car car103 = new Car();
    car103.setBrand(brandAudi);
    car103.setModel(modelA6);
    car103.setDepartment(departmentGdansk);

    Car car104 = new Car();
    car104.setBrand(brandAudi);
    car104.setModel(modelA6);
    car104.setDepartment(departmentKrakow);

    Car car105 = new Car();
    car105.setBrand(brandAudi);
    car105.setModel(modelA6);
    car105.setDepartment(departmentLodz);

    Car car106 = new Car();
    car106.setBrand(brandAudi);
    car106.setModel(modelA6);
    car106.setDepartment(departmentLublin);

    Car car107 = new Car();
    car107.setBrand(brandAudi);
    car107.setModel(modelA6);
    car107.setDepartment(departmentPoznan);

    Car car108 = new Car();
    car108.setBrand(brandAudi);
    car108.setModel(modelA6);
    car108.setDepartment(departmentSzczecin);

    Model modelProAce = new Model();
    modelProAce.setName("ProAce");
    modelProAce.setSection(sectionBus);

    modelDaoBean.saveModel(modelProAce);

    Car car109 = new Car();
    car109.setBrand(brandToyota);
    car109.setModel(modelProAce);
    car109.setDepartment(departmentGdansk);

    Car car110 = new Car();
    car110.setBrand(brandToyota);
    car110.setModel(modelProAce);
    car110.setDepartment(departmentKrakow);

    Car car111 = new Car();
    car111.setBrand(brandToyota);
    car111.setModel(modelProAce);
    car111.setDepartment(departmentLodz);

    Car car112 = new Car();
    car112.setBrand(brandToyota);
    car112.setModel(modelProAce);
    car112.setDepartment(departmentLublin);

    Car car113 = new Car();
    car113.setBrand(brandToyota);
    car113.setModel(modelProAce);
    car113.setDepartment(departmentPoznan);

    Car car114 = new Car();
    car114.setBrand(brandToyota);
    car114.setModel(modelProAce);
    car114.setDepartment(departmentSzczecin);

    Model modelAlhambra = new Model();
    modelAlhambra.setName("Alhambra");
    modelAlhambra.setSection(section7os);

    modelDaoBean.saveModel(modelAlhambra);

    Car car115 = new Car();
    car115.setBrand(brandSeat);
    car115.setModel(modelAlhambra);
    car115.setDepartment(departmentGdansk);

    Car car116 = new Car();
    car116.setBrand(brandSeat);
    car116.setModel(modelAlhambra);
    car116.setDepartment(departmentKrakow);

    Car car117 = new Car();
    car117.setBrand(brandSeat);
    car117.setModel(modelAlhambra);
    car117.setDepartment(departmentLodz);

    Car car118 = new Car();
    car118.setBrand(brandSeat);
    car118.setModel(modelAlhambra);
    car118.setDepartment(departmentLublin);

    Car car119 = new Car();
    car119.setBrand(brandSeat);
    car119.setModel(modelAlhambra);
    car119.setDepartment(departmentPoznan);

    Car car120 = new Car();
    car120.setBrand(brandSeat);
    car120.setModel(modelAlhambra);
    car120.setDepartment(departmentSzczecin);

    carDaoBean.saveCar(car1);
    carDaoBean.saveCar(car2);
    carDaoBean.saveCar(car3);
    carDaoBean.saveCar(car4);
    carDaoBean.saveCar(car5);
    carDaoBean.saveCar(car6);
    carDaoBean.saveCar(car7);
    carDaoBean.saveCar(car8);
    carDaoBean.saveCar(car9);
    carDaoBean.saveCar(car10);
    carDaoBean.saveCar(car11);
    carDaoBean.saveCar(car12);
    carDaoBean.saveCar(car13);
    carDaoBean.saveCar(car14);
    carDaoBean.saveCar(car15);
    carDaoBean.saveCar(car16);
    carDaoBean.saveCar(car17);
    carDaoBean.saveCar(car18);
    carDaoBean.saveCar(car19);
    carDaoBean.saveCar(car20);
    carDaoBean.saveCar(car21);
    carDaoBean.saveCar(car22);
    carDaoBean.saveCar(car23);
    carDaoBean.saveCar(car24);
    carDaoBean.saveCar(car25);
    carDaoBean.saveCar(car26);
    carDaoBean.saveCar(car27);
    carDaoBean.saveCar(car28);
    carDaoBean.saveCar(car29);
    carDaoBean.saveCar(car30);
    carDaoBean.saveCar(car31);
    carDaoBean.saveCar(car32);
    carDaoBean.saveCar(car33);
    carDaoBean.saveCar(car34);
    carDaoBean.saveCar(car35);
    carDaoBean.saveCar(car36);
    carDaoBean.saveCar(car37);
    carDaoBean.saveCar(car38);
    carDaoBean.saveCar(car39);
    carDaoBean.saveCar(car40);
    carDaoBean.saveCar(car41);
    carDaoBean.saveCar(car42);
    carDaoBean.saveCar(car43);
    carDaoBean.saveCar(car44);
    carDaoBean.saveCar(car45);
    carDaoBean.saveCar(car46);
    carDaoBean.saveCar(car47);
    carDaoBean.saveCar(car48);
    carDaoBean.saveCar(car49);
    carDaoBean.saveCar(car50);
    carDaoBean.saveCar(car51);
    carDaoBean.saveCar(car52);
    carDaoBean.saveCar(car53);
    carDaoBean.saveCar(car54);
    carDaoBean.saveCar(car55);
    carDaoBean.saveCar(car56);
    carDaoBean.saveCar(car57);
    carDaoBean.saveCar(car58);
    carDaoBean.saveCar(car59);
    carDaoBean.saveCar(car60);
    carDaoBean.saveCar(car61);
    carDaoBean.saveCar(car62);
    carDaoBean.saveCar(car63);
    carDaoBean.saveCar(car64);
    carDaoBean.saveCar(car65);
    carDaoBean.saveCar(car66);
    carDaoBean.saveCar(car67);
    carDaoBean.saveCar(car68);
    carDaoBean.saveCar(car69);
    carDaoBean.saveCar(car70);
    carDaoBean.saveCar(car71);
    carDaoBean.saveCar(car72);
    carDaoBean.saveCar(car73);
    carDaoBean.saveCar(car74);
    carDaoBean.saveCar(car75);
    carDaoBean.saveCar(car76);
    carDaoBean.saveCar(car77);
    carDaoBean.saveCar(car78);
    carDaoBean.saveCar(car79);
    carDaoBean.saveCar(car80);
    carDaoBean.saveCar(car81);
    carDaoBean.saveCar(car82);
    carDaoBean.saveCar(car83);
    carDaoBean.saveCar(car84);
    carDaoBean.saveCar(car85);
    carDaoBean.saveCar(car86);
    carDaoBean.saveCar(car87);
    carDaoBean.saveCar(car88);
    carDaoBean.saveCar(car89);
    carDaoBean.saveCar(car90);
    carDaoBean.saveCar(car91);
    carDaoBean.saveCar(car92);
    carDaoBean.saveCar(car93);
    carDaoBean.saveCar(car94);
    carDaoBean.saveCar(car95);
    carDaoBean.saveCar(car96);
    carDaoBean.saveCar(car97);
    carDaoBean.saveCar(car98);
    carDaoBean.saveCar(car99);
    carDaoBean.saveCar(car100);
    carDaoBean.saveCar(car101);
    carDaoBean.saveCar(car102);
    carDaoBean.saveCar(car103);
    carDaoBean.saveCar(car104);
    carDaoBean.saveCar(car105);
    carDaoBean.saveCar(car106);
    carDaoBean.saveCar(car107);
    carDaoBean.saveCar(car108);
    carDaoBean.saveCar(car109);
    carDaoBean.saveCar(car110);
    carDaoBean.saveCar(car111);
    carDaoBean.saveCar(car112);
    carDaoBean.saveCar(car113);
    carDaoBean.saveCar(car114);
    carDaoBean.saveCar(car115);
    carDaoBean.saveCar(car116);
    carDaoBean.saveCar(car117);
    carDaoBean.saveCar(car118);
    carDaoBean.saveCar(car119);
    carDaoBean.saveCar(car120);

    Position admin = new Position("Admin");
    Position menager = new Position("Menadżer");
    Position coordinator = new Position("Koordynator");
    Position worker = new Position("Pracownik");

    positionDaoBean.savePosition(admin);
    positionDaoBean.savePosition(menager);
    positionDaoBean.savePosition(coordinator);
    positionDaoBean.savePosition(worker);

    Worker adminWorker = new Worker();
    adminWorker.setDepartment(departmentWarszawa);
    adminWorker.setEmail("manchester_united@onet.pl");
    adminWorker.setFullName("Andrzej Krzywy");
    adminWorker.setPassword(DigestUtils.md5Hex("dupa"));
    adminWorker.setPesel("12345678910");
    adminWorker.setPhoneNumber("666777888");
    adminWorker.setPosition(admin);
    workerDaoBean.saveWorker(adminWorker);

    ClientType neutral = new ClientType("Normalny", "0%");
    ClientType brown = new ClientType("Brązowy", "5%");
    ClientType silver = new ClientType("Srebrny", "10%");
    ClientType gold = new ClientType("Złoty", "15%");

    clientTypeDaoBean.saveClientType(neutral);
    clientTypeDaoBean.saveClientType(brown);
    clientTypeDaoBean.saveClientType(silver);
    clientTypeDaoBean.saveClientType(gold);

  }
}
