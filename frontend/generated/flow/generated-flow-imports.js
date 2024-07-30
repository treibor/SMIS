import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/generated/jar-resources/styles/toolbar-button.css?inline';
const $css_0 = typeof $cssFromFile_0  === 'string' ? unsafeCSS($cssFromFile_0) : $cssFromFile_0;
registerStyles('vaadin-button', $css_0, {moduleId: 'flow_css_mod_0'});
import $cssFromFile_1 from 'print-js/dist/print.css?inline';

injectGlobalCss($cssFromFile_1.toString(), 'CSSImport end', document);
import $cssFromFile_2 from 'Frontend/generated/jar-resources/styles.css?inline';

injectGlobalCss($cssFromFile_2.toString(), 'CSSImport end', document);
import $cssFromFile_3 from 'Frontend/generated/jar-resources/ckeditor.css?inline';

injectGlobalCss($cssFromFile_3.toString(), 'CSSImport end', document);
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/text-field/theme/lumo/vaadin-text-field.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/dialog/theme/lumo/vaadin-dialog.js';
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/password-field/theme/lumo/vaadin-password-field.js';
import '@vaadin/email-field/theme/lumo/vaadin-email-field.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import '@vaadin/combo-box/theme/lumo/vaadin-combo-box.js';
import 'Frontend/generated/jar-resources/comboBoxConnector.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav.js';
import 'Frontend/generated/jar-resources/vaadin-grid-flow-selection-column.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav-item.js';
import 'Frontend/generated/jar-resources/dndConnector.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/grid/theme/lumo/vaadin-grid.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-sorter.js';
import '@vaadin/checkbox/theme/lumo/vaadin-checkbox.js';
import 'Frontend/generated/jar-resources/gridConnector.js';
import 'Frontend/generated/jar-resources/menubarConnector.js';
import '@vaadin/menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import 'Frontend/generated/jar-resources/so/chart/chart.js';
import '@vaadin/avatar/theme/lumo/vaadin-avatar.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column-group.js';
import 'Frontend/generated/jar-resources/lit-renderer.ts';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '49ed8ff4166585dcf29b567e05f6fe39fce200af1c1a8ae7b5ce3f0a204c39e0') {
    pending.push(import('./chunks/chunk-da3ebf3d8335638954d5d609a12cf4ac047302df5cef29788d8b436646112322.js'));
  }
  if (key === '9dcdce97eb6be983b7fbbda11f5ead2fa8ba6e14013d655cfe2e7cad3335963c') {
    pending.push(import('./chunks/chunk-c63e446e9005589eca4d58aed96a4533034cbcd0b5fc6809d83a02c0f8aec3d9.js'));
  }
  if (key === '130fdac2f606b415395067da45456dd0d791445544f7ad3d166f02d18e3093de') {
    pending.push(import('./chunks/chunk-3dd8bb8671d5cc3d5f5539475536525542ad2c7d539f2e5b81a52e446af3e95c.js'));
  }
  if (key === 'cc6a9a9a230166e119979efdc09d9ef284a90119880c86c8af928ccf83fc7b88') {
    pending.push(import('./chunks/chunk-3dd8bb8671d5cc3d5f5539475536525542ad2c7d539f2e5b81a52e446af3e95c.js'));
  }
  if (key === '0153f681941e1b720af11bbb8ba0a99e916d03102d8fa24ec5b23c9dc7d7b74e') {
    pending.push(import('./chunks/chunk-b3ba4a9751acaa090e60448cbb3c6d53adb07cdef81ef5b07544a61fa2014132.js'));
  }
  if (key === '42bb99999e2c1e88421f77d963f4acff8c5e62364dff2127fc662ac9fea1cdfc') {
    pending.push(import('./chunks/chunk-0c952d0655ff873ba0ee8e16d49eebbd827823b10fb994d4b51dfdbfc1b0b10d.js'));
  }
  if (key === '8cd1296780278484c56befb9de72ec763042f3535ec9325e2a92b3a68c14746f') {
    pending.push(import('./chunks/chunk-81d4cc1aa20438ae47ba8332bbba19d37cd58b467936d5de4fd3f69f79f02352.js'));
  }
  if (key === 'ed28b5faf3885a5e351a83211b1dd8e139c98b9849f40792e127744d5d3bed2d') {
    pending.push(import('./chunks/chunk-f01c2ad09a18abe77fb451fa3becf3a75584a0ba15c48893e19dcddeed1329b8.js'));
  }
  if (key === '3368b28ae401a37aec04b5f8d138532a46b6c3b9c4d4377cb3615fb35b8d388d') {
    pending.push(import('./chunks/chunk-848edec907de5be98216c10e72b9459be11cb0b87f7ddc5b1cba273f2016dc54.js'));
  }
  if (key === '21d3b6ee93a374fd3dc19fd4d02e858024d453eed3ba592ab9abc8b257977d38') {
    pending.push(import('./chunks/chunk-b3ba4a9751acaa090e60448cbb3c6d53adb07cdef81ef5b07544a61fa2014132.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;