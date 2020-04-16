package no.kirschner.eessi.nina;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("no.kirschner.eessi.nina");

        noClasses()
            .that()
            .resideInAnyPackage("no.kirschner.eessi.nina.service..")
            .or()
            .resideInAnyPackage("no.kirschner.eessi.nina.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..no.kirschner.eessi.nina.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
